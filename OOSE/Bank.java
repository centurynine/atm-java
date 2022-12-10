import java.io.ObjectInputStream.GetField;
import java.util.Arrays;
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
					login();
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
				
				account[i] = new Account(accountName, accountId, accountPin, accountBalance);
				System.out.println("\n Your account has been created!");
				String infoName = ((Account) account[i]).accountName;
				int infoId = ((Account) account[i]).accountId;
				int infoPin = ((Account) account[i]).accountPin;
				int infoBalance = ((Account) account[i]).accountBalance;
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

	public static void login() {
		int customerNumber = 0;
		int pinNumber = 0;



		System.out.println("\nLogin.");
		System.out.print("\nEnter your customer number: ");
		customerNumber = inputAccountId.nextInt();
		try {
			System.out.println("customerNumber : "+customerNumber); 

			Account[] account;
			account = new Account[customerNumber];
			System.out.println("account.length : "+account.length);
			System.out.println("account Name : "+((Account) account[customerNumber]).accountName);
			System.out.println("account pin : "+Bank.Account.getAccountPin());  
			System.out.println("account Balance : "+Bank.Account.getAccountBalance());
			System.out.println("account ID : "+Bank.Account.getAccountId());
			
			// for (int i = 0; i < account.length; i++) {
			// 	if (customerNumber == ((Account) account[i]).accountId) {
			// 		System.out.println("Enter your pin number: ");
			// 		pinNumber = inputAccountPin.nextInt();
			// 		if (pinNumber == ((Account) account[i]).accountPin) {
			// 			System.out.println("Login Successful!");
			// 			System.out.println("Welcome " + ((Account) account[i]).accountName);
			// 			System.out.println("Your balance is " + ((Account) account[i]).accountBalance);
			// 		} else {
			// 			System.out.println("Invalid Pin Number.");
			// 		}
			// 	} else {
			// 		System.out.println("Invalid Customer Number.");
			// 	}
			// }
			welcomeMenu();

			// Account[] account;
			// account = new Account[2];

			// for (int i = 0; i < account.length; i++) {
			// 	if (customerNumber == ((Account) account[i]).accountId) {
			// 		System.out.println("Enter your pin number: ");
			// 		pinNumber = inputAccountPin.nextInt();
			// 		if (pinNumber == ((Account) account[i]).accountPin) {
			// 			System.out.println("Login Successful!");
			// 			System.out.println("Welcome " + ((Account) account[i]).accountName);
			// 			System.out.println("Your balance is " + ((Account) account[i]).accountBalance);
			// 		} else {
			// 			System.out.println("Invalid Pin Number.");
			// 		}
			// 	} else {
			// 		System.out.println("Invalid Customer Number.");
			// 	}
			// }

			

	} catch (InputMismatchException e) {
		System.out.println("\nError " +e+ " Please try again"); 
	}
	}


public static class Account {
	
	private static int accountPin;
	private static int accountId;
	private static String accountName;
	private static int accountBalance;

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



	public static int getAccountPin() {
		return accountPin;
	}

	public static int getAccountId() {
		return accountId;
	}

	public static String getAccountName() {
		return accountName;
	}

	public static int getAccountBalance() {
		return accountBalance;
	}

}

}
