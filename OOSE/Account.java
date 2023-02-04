import java.util.Scanner;

public class Account extends Person {
    Manager[] 
    manager = new Manager[1];
    private String accountPin;
    private String accountId;
    private String accountName;
    private int accountBalance;
    private boolean accountInfo;
    private boolean accountManager;
    private String accountManagerId;
    private boolean isManager = false;


    public Account(String accountName, String accountId, String accountPin, int accountBalance) {
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
 
        Scanner inputAccountId = new Scanner(System.in);
        manager[0] = new Manager();
        manager[0].setManager(managerId);
        manager[0].setHaveManager(true); 
        manager[0].setAccount(accountId, accountPin);
        this.isManager = true;
        this.accountManager = true;
        System.out.println("Manager ID : " + manager[0].getManagerId());
    }

    public void getManagerInformation() {
        System.out.println("Manager ID: " + manager[0].getManagerId());
        System.out.println("Manager Password: " + manager[0].getManagerId());
        System.out.println("Have Manager: " + manager[0].getManagerId());
    }

    public String getManagerId() {
        return manager[0].getManagerId();
    }

    public boolean getIsManager() {
        return isManager;
    }

}

