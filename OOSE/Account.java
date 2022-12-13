public class Account extends Person {

    private String accountPin;
    private String accountId;
    private String accountName;
    private int accountBalance;
    private boolean accountInfo;

    public Account(String accountPin, String accountId, String accountName, int accountBalance) {
        this.accountPin = accountPin;
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public String getAccountPin() {
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

    public boolean getaccountInfo() {
        return accountInfo;
    }

    public void setAccountBalance(int balance) {
        this.accountBalance = balance;
    }

    public void setaccountInfo(boolean accountInfo) {
        this.accountInfo = accountInfo;
    }

}

