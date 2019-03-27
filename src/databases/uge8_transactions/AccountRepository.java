package databases.uge8_transactions;
import java.sql.*;

/**
 * Reference: https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html#commit_transactions
 *
 * Got DEADLOCK. Solved by saying Commit; in Workbench
 *
 * Make deadlock:
 * 1. Start transaction in workbench
 * 2. UPDATE account (NOT COMMIT)
 * 3. Run JDBC koden
 *
 */
public class AccountRepository {
    private final String url = "jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185144?";
    private final String userName= "user=s185144";
    private final String pass = "password=XFfpicTFLy2RzYknRgLMO";

    public void updateAccount(Transaction transaction) {

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url + userName + "&" + pass);

            PreparedStatement pStmtFrom = connection.prepareStatement(
                    "UPDATE account SET balance = balance - ? WHERE account_number = ?");
            PreparedStatement pStmtTO = connection.prepareStatement(
                    "UPDATE account SET balance = balance + ? WHERE account_number = ?");

            connection.setAutoCommit(false);

            pStmtFrom.setInt(1, transaction.getAmount());
            pStmtFrom.setInt(2, transaction.getAccountNumberFrom());
            pStmtFrom.executeUpdate();


            if(true){
                throw new SQLException("Test exception");
            }

            pStmtTO.setInt(1, transaction.getAmount());
            pStmtTO.setInt(2, transaction.getAccountNumberTo());
            pStmtTO.executeUpdate();

            connection.commit();
        } catch (SQLException e){

            if(connection != null){
                try{
                    e.printStackTrace();
                    System.out.println("The transcation is being rolled back");
                    connection.rollback();
                } catch (SQLException es){
                    es.printStackTrace();
                }
            }
        } finally {
            if ( connection != null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
