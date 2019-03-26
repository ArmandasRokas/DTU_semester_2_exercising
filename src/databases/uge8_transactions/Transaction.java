package databases.uge8_transactions;

public class Transaction {
    private int accountNumberFrom;
    private int accountNumberTo;
    private int amount;

    public int getAccountNumberFrom() {
        return accountNumberFrom;
    }

    public void setAccountNumberFrom(int accountNumberFrom) {
        this.accountNumberFrom = accountNumberFrom;
    }

    public int getAccountNumberTo() {
        return accountNumberTo;
    }

    public void setAccountNumberTo(int accountNumberTo) {
        this.accountNumberTo = accountNumberTo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
