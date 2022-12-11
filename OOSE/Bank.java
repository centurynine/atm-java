import java.util.InputMismatchException;
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
		System.out.println("@@@@  Welcome to the RmuttBank! @@@@");
		while (end == false) {
			try {
				System.out.println("\n Type 1 - Create Account");
				System.out.println(" Type 2 - Exit");
				System.out.print("\nChoice: ");
				int choice = inputChoice.nextInt();
				switch (choice) {
					case 1:
						System.out.print("\nCreate Account.");
						manageAccount();
						end = true;
						break;
					case 2:
						System.out.println("\nExit.");
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

	public static void manageAccount() {
		System.out.print("\n Enter amount of all account: ");
		int accountLimit = inputAccountLimit.nextInt();
		Account[] account;
		account = new Account[accountLimit];
		try {
			for (int i = 0; i < accountLimit; i++) {
				System.out.print("\n No." + (i + 1) + " Account");
				System.out.print("\n Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.print(" Enter your account ID: ");
				String accountId = inputAccountId.nextLine();
				System.out.print(" Enter your account pin: ");
				int accountPin = inputAccountPin.nextInt();
				System.out.print(" Enter your account balance: ");
				int accountBalance = inputAccountBalance.nextInt();
				account[i] = new Account(accountName, accountId, accountPin, accountBalance);

			}
			System.out.println("******************************");

			for (int j = 0; j < accountLimit; j++) {
				int no = j + 1;
				System.out.println("\nNo." + no);
				System.out.println("Account ID = " + ((Account) account[j]).accountId);
				System.out.println("Account Name = " + ((Account) account[j]).accountName);
				System.out.println("Account Pin = " + ((Account) account[j]).accountPin);
				System.out.println("Account Balance = " + ((Account) account[j]).accountBalance);
			}

		} catch (InputMismatchException e) {
			System.out.println("\nError " + e + " Please try again");
		}
		System.out.println("\n ########## Login Menu ##########");
		System.out.print("\n Enter your account ID: ");
		String accountLoginId = inputAccountId.nextLine();
		System.out.print(" Enter your account pin: ");
		int accountLoginPin = inputAccountPin.nextInt();
		for (int k = 0; k < accountLimit; k++) {
			if (accountLoginId.equals(((Account) account[k]).accountId)) {
				if (accountLoginPin == ((Account) account[k]).accountPin) {
					System.out.println("\n **** Login Success!");
					System.out.println(" **** Account Name: " + ((Account) account[k]).accountName + " Account ID: "
							+ ((Account) account[k]).accountId + " Account Pin: " + ((Account) account[k]).accountPin
							+ " Account Balance: " + ((Account) account[k]).accountBalance);
					System.out.println("****************** ACCOUNT MENU ******************");
					System.out.println("Welcome : " + ((Account) account[k]).accountName);
					System.out.println(" Type 1 - Deposit");
					System.out.println(" Type 2 - Withdraw");
					System.out.println(" Type 3 - Transfer");
					System.out.println(" Type 4 - Check Balance");
					System.out.println(" Type 5 - Exit");
					System.out.println("Choice: ");
					int choice = inputChoice.nextInt();
					welcomeMenu();
				} else {

					System.out.println("\n!!! Login Failed !!!");
				}

			} else {

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

	}

}
