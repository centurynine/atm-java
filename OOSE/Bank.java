import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Bank {
	static Scanner inputChoice = new Scanner(System.in);
	static Scanner inputAccountName = new Scanner(System.in);
	static Scanner inputAccountId = new Scanner(System.in);
	static Scanner inputAccountPin = new Scanner(System.in);
	static Scanner inputAccountBalance = new Scanner(System.in);
	static Scanner inputAccountLimit = new Scanner(System.in);
 
	public static void main(String[] args) {
		welcomeMenu();

	}

	public static void welcomeMenu() {
		boolean end = false;
		System.out.println("Welcome to the Bank!");
		while (end == false) {
			try {
				System.out.println(" Type 1 - Create Account");
				System.out.print("\nChoice: ");
				int choice = inputChoice.nextInt();
				switch (choice) {
				case 1:
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
		System.out.println("\n Enter amount of all account: ");
		int accountLimit = inputAccountLimit.nextInt();
		Account[] account;
		account = new Account[accountLimit];
		try {
			for (int i = 0; i < accountLimit; i++) {
				

				System.out.println("\n Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.println("\n Enter your account ID: ");
				String accountId = inputAccountId.nextLine();
				System.out.println("\n Enter your account pin: ");
				int accountPin = inputAccountPin.nextInt();
				System.out.println("\n Enter your account balance: ");
				int accountBalance = inputAccountBalance.nextInt();
				
				account[i] = new Account(accountName, accountId, accountPin, accountBalance);
				System.out.println("\n Your account has been created!");
				String infoName = ((Account) account[i]).accountName;
				String infoId = ((Account) account[i]).accountId;
				int infoPin = ((Account) account[i]).accountPin;
				int infoBalance = ((Account) account[i]).accountBalance;
				System.out.println("\n Account Name: " + infoName + " Account ID: " + infoId + " Account Pin: " + infoPin + " Account Balance: " + infoBalance);

			}
			System.out.println("******************************");

			for (int j = 0; j < accountLimit; j++) {
				int no = j+1;
				System.out.println("No."+ no +" Name: " + ((Account) account[j]).accountName + " Account ID: " + ((Account) account[j]).accountId + " Account Pin: " + ((Account) account[j]).accountPin + " Account Balance: " + ((Account) account[j]).accountBalance);
			}
	

		}
		catch (InputMismatchException e) {
			System.out.println("\nError " +e+ " Please try again");
		}
		System.out.println("\n Login Menu ");
		System.out.println("\n Enter your account ID: ");
		String accountLoginId = inputAccountId.nextLine();
		System.out.println("\n Enter your account pin: ");
		int accountLoginPin = inputAccountPin.nextInt();
		for (int k = 0; k < accountLimit; k++) {
			if (accountLoginId == ((Account) account[k]).accountId && accountLoginPin == ((Account) account[k]).accountPin) {
				System.out.println("\n Login Success!");
				System.out.println("\n Account Name: " + ((Account) account[k]).accountName + " Account ID: " + ((Account) account[k]).accountId + " Account Pin: " + ((Account) account[k]).accountPin + " Account Balance: " + ((Account) account[k]).accountBalance);
				System.out.print("****************** ACCOUNT MENU ******************");
				System.out.println("\n Type 1 - Deposit");
				System.out.println("\n Type 2 - Withdraw");
				System.out.println("\n Type 3 - Transfer");
				System.out.println("\n Type 4 - Check Balance");
				System.out.println("\n Type 5 - Exit");
				System.out.print("\nChoice: ");
				int choice = inputChoice.nextInt();

			}
			else {
				System.out.println(accountLoginId);
				System.out.println(((Account) account[k]).accountId);
				System.out.println("\n Login Failed!");
			}
		}

	}



public static class Account {
	
	private int accountPin;
	private String accountId;
	private String accountName;
	private int accountBalance;
 
	
	public Account(String accountName, String accountId, int accountPin, int accountBalance) {

		this.accountPin = accountPin;
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
 
		System.out.println("Created!" + " Account Name: " + accountName + " Account ID: " + accountId + " Account Pin: " + accountPin + " Account Balance: " + accountBalance);
		
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

}

}
