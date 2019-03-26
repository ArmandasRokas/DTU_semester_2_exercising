package databases.uge8_transactions;

public class Main {

    public static void main(String[] args) {

        Transaction transaction = new Transaction();
        transaction.setAccountNumberFrom(123);
        transaction.setAccountNumberTo(456); // tru not to give value here
        transaction.setAmount(100);

        AccountRepository accountRepository = new AccountRepository();
        accountRepository.updateAccount(transaction);

    }
}
