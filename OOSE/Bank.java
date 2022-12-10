import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
	static Scanner inputChoice = new Scanner(System.in);
	static Scanner inputAccountName = new Scanner(System.in);
	static Scanner inputAccountId = new Scanner(System.in);
	static Scanner inputAccountPin = new Scanner(System.in);
	static Scanner inputAccountBalance = new Scanner(System.in);
	static Scanner inputAccountLimit = new Scanner(System.in);
	
	private int balance;
	private int pin;
	private int accountId;
	private String accountName;

	public static void main(String[] args) {
		welcomeMenu();

	}

	public static void welcomeMenu() {
	    int accountLimit;
		boolean end = false;
		System.out.println("Welcome to the Bank!");
		while (end == false) {
			try {
				System.out.println("\n Type 1 - Login");
				System.out.println(" Type 2 - Create Account");
				System.out.print("\nChoice: ");
				int choice = inputChoice.nextInt();
				switch (choice) {
				case 1:
					System.out.println("\nLogin.");
					end = true;
					break;
				case 2:
				System.out.println("\nCreate Account.");
					createAccount();
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
			}
		}
	}

	public static void createAccount(){
		try {
			System.out.println("\n Enter amount of all account: ");
			int accountLimit = inputAccountLimit.nextInt();

			Account[] account;
			account = new Account[accountLimit];

			for (int i = 0; i < accountLimit; i++) {
				

				System.out.println("\n Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.println("\n Enter your account ID: ");
				int accountId = inputAccountId.nextInt();
				System.out.println("\n Enter your account pin: ");
				int accountPin = inputAccountPin.nextInt();
				System.out.println("\n Enter your account balance: ");
				int accountBalance = inputAccountBalance.nextInt();
			 
				account[i] = new Account(accountName, accountId, accountPin,accountBalance);
				System.out.println("\n Your account has been created!");
				String infoName = ((Account) account[accountId]).accountName;
				int infoId = ((Account) account[accountId]).accountId;
				int infoPin = ((Account) account[accountId]).accountPin;
				int infoBalance = ((Account) account[accountId]).accountBalance;
				System.out.println("\n Account Name: " + infoName + " Account ID: " + infoId + " Account Pin: " + infoPin + " Account Balance: " + infoBalance);

			}
			System.out.println("******************************");

			// for (int j = 0; j < accountLimit; j++) {
			// 	int no = j+1;
			// 	System.out.println("No."+ no +" Name: " + ((Account) account[j]).accountName + " Account ID: " + ((Account) account[j]).accountId + " Account Pin: " + ((Account) account[j]).accountPin + " Account Balance: " + ((Account) account[j]).accountBalance);
			// }

			

		}
		catch (InputMismatchException e) {
			System.out.println("\nError " +e+ " Please try again");
		}
		welcomeMenu();

	}

public static class Account {
	
	private int accountPin;
	private int accountId;
	private String accountName;
	private int accountBalance;

	public Account() {
		this.accountPin = 0;
		this.accountId = 0;
		this.accountName = "";
		this.accountBalance = 0;
	}

	public Account(String accountName, int accountId, int accountPin, int accountBalance) {

		this.accountPin = accountPin;
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountBalance = accountBalance;

		System.out.println("\n Your account has been created!" + " Account Name: " + accountName + " Account ID: " + accountId + " Account Pin: " + accountPin + " Account Balance: " + accountBalance);
		
	}

}

}
