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
	static int accountCount = 0;
	boolean haveManager = false;
	public static void main(String[] args) {
		Account[] account;
		account = new Account[9999];
		Person[] person;
		person = new Person[9999];

		welcomeMenu(account);
	}

	public static void welcomeMenu(Account[] account) {

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
						manageAccount(account);
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

	public static void Login(Account[] account, int accountCount) {
		boolean end = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@  Welcome to the RMUTT BANK @@@@");
		while (end == false) {
			try {
				System.out.println("\n Type 1 - Create Account");
				System.out.println(" Type 2 - Login");
				System.out.println(" Type 3 - Set Manager");
				System.out.println(" Type 4 - Get Info Manager");
				System.out.println(" Type 5 - Exit");
				System.out.print("\nChoice: ");
				int choice = inputChoice.nextInt();
				switch (choice) {
					case 1:
						System.out.print("\nCreate Account.");
						createAccount(account, accountCount);
						end = true;
						break;
					case 2:
						System.out.println("\nLogin.");
						LoginSystem(account, accountCount);
						end = true;
						break;
					case 3:
						System.out.println("\nSet Manager.");
						setManager(account, accountCount);
						end = true;
						break;
					case 4:
						System.out.println("\nGet Manager.");
						getManagerInfo(account, accountCount);
						end = true;
						break;
					case 5:
						System.out.println("\nExit.");
						end = true;
						System.exit(0);
						break;
 
					default:
						System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nError" + e);
			}

		}
	}

	public static void LoginSystem(Account[] account, int accountCount) { 
		int choice = 0;
		boolean holderAccount = true;
		while (holderAccount == true) {
			boolean holderMenu = true;
			System.out.println("\n ########## Login Menu ##########");
			System.out.print("\n Enter your account ID: ");
			String accountLoginId = inputAccountId.nextLine();
			System.out.print(" Enter your account pin: ");
			String accountLoginPin = inputAccountPin.nextLine();
			System.out.println("\n #################################");
			for (int k = 0; k < accountCount; k++) {
				if (accountLoginId.equals(((Account) account[k]).getAccountId())) {
					if (accountLoginPin.equals(((Account) account[k]).getAccountPin())) {
						System.out.println("\n **** Login Success!");
						System.out.println(
								" **** Account Name: " + ((Account) account[k]).getAccountName() + " Account ID: "
										+ ((Account) account[k]).getAccountId() + " Account Pin: "
										+ ((Account) account[k]).getAccountPin()
										+ " Account Balance: " + ((Account) account[k]).getAccountBalance());
						while (holderMenu == true) {
							System.out.println("****************** ACCOUNT MENU ******************");
							System.out.println("Welcome : " + ((Account) account[k]).getAccountName());
							System.out.println(" Type 1 - Check Balance");
							System.out.println(" Type 2 - Withdraw");
							System.out.println(" Type 3 - Deposit");
							System.out.println(" Type 4 - Change account");
							if(((Account) account[k]).getaccountInfo() == true) {
								System.out.println(" Type 5 - Check account information");
							}
							else {
								System.out.println(" Type 5 - Register account information");
							}
							System.out.println(" Type 6 - Exit");
							System.out.print("Choice: ");
							choice = inputChoice.nextInt();
							switch (choice) {
								case 1:
									System.out.println(
											"\n === Your Balance is " + ((Account) account[k]).getAccountBalance());
									break;
								case 2:
									System.out.println("\n Withdraw.");
									withdraw(account, k);
									break;
								case 3:
									System.out.println("\n Deposit.");
									deposit(account, k);
									break;
								case 4:
									System.out.println("\n Change account.");
									holderAccount = true;
									holderMenu = false;
									Login(account, accountCount);
									break;
								case 5:
									if(((Account) account[k]).getaccountInfo() == true) {
										System.out.println(" Type 5 - Check account information");
										getAccountInfo(account, k);
										break;
									}
									else {
									System.out.println(" Type 5 - Register account information");
									setAccountInfo(account, k);
									break;
								}
								case 6:
									System.out.println("\n Exit.");
									holderAccount = false;
									holderMenu = false;
									System.exit(0);
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


	public static void manageAccount(Account[] account) {

		boolean holderAccount = true;
		System.out.print("\n Enter amount of all account: ");
		int accountLimit = inputAccountLimit.nextInt();

		try {
			for (int i = 0; i < accountLimit; i++) {
				System.out.print("\n No." + (i + 1) + " Account");
				System.out.print("\n Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.print(" Enter your account ID: ");
				String accountId = inputAccountId.nextLine();
				System.out.print(" Enter your account pin: ");
				String accountPin = inputAccountPin.nextLine();
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
				if (i == 0) {
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

		Login(account, accountLimit);

	}

	public static void createAccount(Account[] account, int accountCount) {

		System.out.print("\n Enter amount of all account: ");
		int accountLimit = inputAccountLimit.nextInt();
		int accountCreateStart = accountCount;
		accountLimit = accountLimit + accountCount;

		try {
			for (int i = accountCount; i <= accountLimit - 1; i++) {
				System.out.print("\n No." + (i + 1) + " Account");
				System.out.print("\n Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.print(" Enter your account ID: ");
				String accountId = inputAccountId.nextLine();
				System.out.print(" Enter your account pin: ");
				String accountPin = inputAccountPin.nextLine();
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
				if (i == 0) {
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

			for (int j = 0; j < accountCount; j++) {
				int no = j + 1;
				System.out.println("\nNo." + no);
				System.out.println("Account ID = " + ((Account) account[j]).getAccountId());
				System.out.println("Account Name = " + ((Account) account[j]).getAccountName());
				System.out.println("Account Pin = " + ((Account) account[j]).getAccountPin());
				System.out.println("Account Balance = " + ((Account) account[j]).getAccountBalance());
			}
			if (accountCount == accountLimit) {
				Login(account, accountCount);
			}
		} catch (InputMismatchException e) {
			System.out.println("\nError " + e + " Please try again");
		}
	}

	public static void setAccountInfo(Account[] account, int accountId) {
		Scanner inputFirstName = new Scanner(System.in);
		Scanner inputLastName = new Scanner(System.in);
		Scanner inputIdCard = new Scanner(System.in);
		Scanner inputGender = new Scanner(System.in);

		System.out.println(" Enter your first name: ");
		String fisrtName = inputAccountName.nextLine();
		System.out.println(" Enter your last name: ");
		String lastName = inputAccountName.nextLine();
		System.out.println(" Enter your idcard: ");
		String idCard = inputAccountName.nextLine();
		System.out.println(" Enter your gender: ");
		String gender = inputAccountName.nextLine();
		((Account) account[accountId]).setAccount(fisrtName, lastName, idCard , gender);
		((Account) account[accountId]).setaccountInfo(true);
		System.out.println("********** Set Account Information Success!");
	}

	public static void getAccountInfo(Account[] account, int accountId){
		System.out.println("********** Your Account Information **********");
		System.out.println("First Name = " + ((Account) account[accountId]).getAccountFirstName());
		System.out.println("Last Name = " + ((Account) account[accountId]).getAccountLastName());
		System.out.println("ID Card = " + ((Account) account[accountId]).getAccountIdCard());
		System.out.println("Gender = " + ((Account) account[accountId]).getAccountGender());
		System.out.println("**********************************************");
		

	}


	public static void setManager(Account[] account, int accountCount) {
		Scanner inputManager = new Scanner(System.in);
		System.out.print("\n Enter New Manager ID: ");
		String setManagerId = inputManager.nextLine();
		for (int i = 0; i < accountCount; i++) {
			if (account[i].getAccountId().equals(setManagerId)) {
				String id = ((Account) account[i]).getAccountId();
				((Account) account[i]).setManager(id);
				System.out.println("********** Set Manager Success!");
				System.out.println(" Manager ID = " + ((Account) account[i]).getAccountId());
				break;
			} else if (i == accountCount - 1) {
				System.out.println("********** Set Manager Fail!");
				break;
			}

		}
		Login(account, accountCount);
	}

	public static void getManagerInfo(Account[] account, int accountCount) {
		for (int i = 0; i < accountCount; i++) {
			if (((Account) account[i]).getAccountManager() == true) {
				System.out.println("********** Manager Information **********");
				System.out.println("Manager ID = " + ((Account) account[i]).getAccountId());
				System.out.println("Manager Name = " + ((Account) account[i]).getAccountName());
				System.out.println("Manager Pin = " + ((Account) account[i]).getAccountPin());
				System.out.println("Manager Balance = " + ((Account) account[i]).getAccountBalance());
				System.out.println("****************************************");
				break;
			} else if (i == accountCount - 1) {
				System.out.println("********** No Manager **********");
				break;
			}
		}
		Login(account, accountCount);
	}

	public static void deposit(Account[] account, int accountId) {
		Scanner inputAccountDeposit = new Scanner(System.in);
		System.out.println(" Enter deposit amount: ");
		int deposit = inputAccountDeposit.nextInt();
		int balance = ((Account) account[accountId]).getAccountBalance();
		balance += deposit;
		((Account) account[accountId]).setAccountBalance(balance);
		System.out.println("Deposit Success!");
		System.out.println("Your Balance is " + ((Account) account[accountId]).getAccountBalance());
	}

	public static void withdraw(Account[] account, int accountId) {
		Scanner inputAccountWithdraw = new Scanner(System.in);
		System.out.println(" Enter withdraw amount: ");
		int withdraw = inputAccountWithdraw.nextInt();
		if (withdraw > ((Account) account[accountId]).getAccountBalance()) {
			System.out.println("Insufficient Balance");
		} else {
			int balance = ((Account) account[accountId]).getAccountBalance();
			balance -= withdraw;
			((Account) account[accountId]).setAccountBalance(balance);
			System.out.println("Withdraw Success!");
			System.out.println("Your Balance is " + ((Account) account[accountId]).getAccountBalance());
		}
	}

}