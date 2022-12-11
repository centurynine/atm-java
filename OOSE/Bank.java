import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
	static Scanner inputChoice = new Scanner(System.in);
	static Scanner inputAccountName = new Scanner(System.in);
	static Scanner inputAccountId = new Scanner(System.in);
	static Scanner inputAccountPin = new Scanner(System.in);
	static Scanner inputAccountBalance = new Scanner(System.in);
	static Scanner inputAccountLimit = new Scanner(System.in);
	static Scanner inputAccountWithdraw = new Scanner(System.in);

	public static void main(String[] args) {

		welcomeMenu();

	}

	public static void welcomeMenu() {
		boolean end = false;
		System.out.println("@@@@  Welcome to the RMUTT BANK @@@@");
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
				System.out.println("\nError" + e);
			}
		}
	}

	public static void manageAccount() {
		boolean holderAccount = true;
		int accountCount = 0;
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
				if (accountName.trim().isEmpty() || accountId.trim().isEmpty()) {
					System.out.println("Please enter all information.");
					i--;
					continue;
				}
				if (accountName.trim().length() > 50 || accountId.trim().length() > 13) {
					System.out.println("too many characters.");
					i--;
					continue;
				}
				if ( i == 0 ) {
					account[i] = new Account(accountName, accountId, accountPin, accountBalance);
					accountCount++;
				} else {
					for (int j = 0; j < accountCount; j++) {
						if (account[j].getAccountId().equals(accountId)) {
							System.out.println("Account ID already exists.");
							i--;
							break;
						} else if (j == accountCount - 1) {
							account[i] = new Account(accountName, accountId, accountPin, accountBalance);
							accountCount++;
							break;
						}
					}
				}


			}
			System.out.println("******************************");

			for (int j = 0; j < accountLimit; j++) {
				int no = j + 1;
				System.out.println("\nNo." + no);
				System.out.println("Account ID = " + ((Account) account[j]).getAccountId());
				System.out.println("Account Name = " + ((Account) account[j]).getAccountName());
				System.out.println("Account Pin = " + ((Account) account[j]).getAccountPin());
				System.out.println("Account Balance = " + ((Account) account[j]).getAccountBalance());
			}

		} catch (InputMismatchException e) {
			System.out.println("\nError " + e + " Please try again");
		}

		int choice = 0;
		while(holderAccount == true){
			boolean holderMenu = true;
			System.out.println("\n ########## Login Menu ##########");
			System.out.print("\n Enter your account ID: ");
			String accountLoginId = inputAccountId.nextLine();
			System.out.print(" Enter your account pin: ");
			int accountLoginPin = inputAccountPin.nextInt();
			System.out.println("\n #################################");
			for (int k = 0; k < accountLimit; k++) {
				if (accountLoginId.equals(((Account) account[k]).getAccountId())) {
					if (accountLoginPin == ((Account) account[k]).getAccountPin()) {
						System.out.println("\n **** Login Success!");
						System.out.println(" **** Account Name: " + ((Account) account[k]).getAccountName() + " Account ID: "
								+ ((Account) account[k]).getAccountId() + " Account Pin: " + ((Account) account[k]).getAccountPin()
								+ " Account Balance: " + ((Account) account[k]).getAccountBalance());
						while (holderMenu == true) {
							System.out.println("****************** ACCOUNT MENU ******************");
							System.out.println("Welcome : " + ((Account) account[k]).getAccountName());
							System.out.println(" Type 1 - Check Balance");
							System.out.println(" Type 2 - Withdraw");
							System.out.println(" Type 3 - Change account");
							System.out.println(" Type 4 - Exit");
							System.out.print("Choice: ");
							choice = inputChoice.nextInt();
							switch (choice) {
							case 1:
								System.out.println("\n === Your Balance is " + ((Account) account[k]).getAccountBalance());
								break;
							case 2:
								System.out.print("\n === Enter amount to withdraw: ");
								int withdraw = inputAccountWithdraw.nextInt();
								if (withdraw > ((Account) account[k]).getAccountBalance()) {
									System.out.println("Insufficient Balance");
									} else {
										int balance = ((Account) account[k]).getAccountBalance();
										balance -= withdraw;
										((Account) account[k]).setAccountBalance(balance);
										System.out.println("Withdraw Success!");
										System.out.println("Your Balance is " + ((Account) account[k]).getAccountBalance());
									}
								break;
							case 3:
								System.out.println("\n Change account.");
								holderAccount = true;
								holderMenu = false;
								break;
							case 4:
								System.out.println("\n Exit.");
								holderAccount = false;
								holderMenu = false;
								break;
							default:
								System.out.println("\n Invalid Choice.");
						}
					}
				} else {

					System.out.println("\n!!! Invalid Password !!!");
				}

			} else {

			}
		}
	}

	}

}