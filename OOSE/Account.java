import java.util.Scanner;

public class Account extends Person {

    private String accountPin;
    private String accountId;
    private String accountName;
    private int accountBalance;
    private boolean accountInfo;
    private boolean accountManager;
    private Manager manager;

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

    public boolean getAccountManager() {
        return accountManager;
    }

    public void setAccountBalance(int balance) {
        this.accountBalance = balance;
    }

    public void setaccountInfo(boolean accountInfo) {
        this.accountInfo = accountInfo;
    }

    public void setManager(String managerId) {
        Manager[] 
        manager = new Manager[99];
        Scanner inputAccountId = new Scanner(System.in);
        manager[0] = new Manager();
        manager[0].setManager(managerId);
        manager[0].setHaveManager(true); 
        manager[0].setAccount(accountId, accountPin);
        this.accountManager = true;
        System.out.println("Manager ID: " + manager[0].getManagerId());
    }

    public void getManagerInformation() {
        System.out.println("Manager ID: " + manager.getManagerId());
        System.out.println("Manager Password: " + manager.getManagerPassword());
        System.out.println("Have Manager: " + manager.getHaveManager());
    }

    public void getAccountManager( Manager manager) {
        
    }

}

