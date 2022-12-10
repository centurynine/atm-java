import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BankTest {
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
	    int accountLimit;
		boolean end = false;
		System.out.println("Welcome to the Bank!");
		while (end == false) {
			try {
				System.out.println(" Type 1 - Login");
				System.out.println(" Type 2 - Create Account");
				System.out.println(" Type 3 - Exit");
				System.out.print("Choice: ");
				int choice = inputChoice.nextInt();
				switch (choice) {
				case 1:
					login();
					end = true;
					break;
					case 2:
					System.out.println("Create Account.");
						createAccount();
						end = true;
						break;
				 	case 3:
						System.out.println("Exit.");
						end = true;
						break;
				default:
					System.out.println("Invalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Choice.");
			}
		}
	}

	public static void createAccount(){

		
		try {
			System.out.println(" Enter amount of all account: ");
			int accountLimit = inputAccountLimit.nextInt();

			Account[] account;
			account = new Account[accountLimit];

			for (int i = 0; i < accountLimit; i++) {
				

				System.out.println(" Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.println(" Enter your account ID: ");
				int accountId = inputAccountId.nextInt();
				System.out.println(" Enter your account pin: ");
				int accountPin = inputAccountPin.nextInt();
				System.out.println(" Enter your account balance: ");
				int accountBalance = inputAccountBalance.nextInt();

				Account b1 = new Account(accountId , accountName , accountPin , accountBalance);
				b1.setAccountId(accountId);
				b1.setAccountPin(accountPin);
				b1.setAccountName(accountName);
				b1.setAccountBalance(accountBalance);
				b1.displayAccount();
			}
	
			 
			
			System.out.println("******************************");

			// for (int j = 0; j < accountLimit; j++) {
			// 	int no = j+1;
			// 	System.out.println("No."+ no +" Name: " + ((Account) account[j]).accountName + " Account ID: " + ((Account) account[j]).accountId + " Account Pin: " + ((Account) account[j]).accountPin + " Account Balance: " + ((Account) account[j]).accountBalance);
			// }
	

		}
		catch (InputMismatchException e) {
			System.out.println("Error " +e+ " Please try again");
		}

		welcomeMenu();

	}

	public static void login() {
		int customerNumber = 0;
		int pinNumber = 0;



		System.out.println("Login.");
		System.out.print("Enter your customer number: ");
		customerNumber = inputAccountId.nextInt();
		try {
			
			
			welcomeMenu();
 

			

	} catch (InputMismatchException e) {
		System.out.println("Error " +e+ " Please try again"); 
	}
	}


public static class Account {
	
	private int accountPin;
	private int accountId;
	private String accountName;
	private int accountBalance;
	

	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Account(int Id, String Name, int Pin, int Balance){
        this.accountId = Id;
	    this.accountName = Name;
		this.accountPin = Pin;
		this.accountBalance	= Balance;
    } 

	public Account getAccountInfo(int accountId) {
		Account b1 = new Account(accountId , accountName , accountPin , accountBalance);
		return b1;
	}

	public void displayAccount() {
		System.out.println("Account Name: " + this.accountId);
		System.out.println("Account ID: " + this.accountId);
		System.out.println("Account Pin: " + this.accountPin);
		System.out.println("Account Balance: " + this.accountBalance);

	}

	public int getAccountPin() {
		return this.accountPin;
	}

	public int getAccountId() {
		return this.accountId;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public int getAccountBalance() {
		return this.accountBalance;
	}

}

}
