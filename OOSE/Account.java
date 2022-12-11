public class Account {

    private int accountPin;
    private String accountId;
    private String accountName;
    int accountBalance;

    public Account(String accountName, String accountId, int accountPin, int accountBalance) {

        this.accountPin = accountPin;
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountBalance = accountBalance;

        System.out.println(" Created!" + " Account Name: " + accountName + " Account ID: " + accountId
                + " Account Pin: " + accountPin + " Account Balance: " + accountBalance);

    }

    public int getAccountPin() {
        return accountPin;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

}