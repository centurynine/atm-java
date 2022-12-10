import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner inputChoice = new Scanner(System.in);
	static Scanner inputAccountName = new Scanner(System.in);
	static Scanner inputAccountId = new Scanner(System.in);
	static Scanner inputAccountPin = new Scanner(System.in);

	Scanner menuInput = new Scanner(System.in);

	public void getLogin(){
		boolean end = false;
		int customerNumber = 0;
		int pinNumber = 0;


		while (!end) {
			try {
				System.out.print("\nEnter your customer number: ");
				customerNumber = inputAccountId.nextInt();
				System.out.print("\nEnter your PIN number: ");
				pinNumber = inputAccountPin.nextInt();
			 
				// if(customerNumber == account[customerNumber].getAccountId() && pinNumber == account[customerNumber].getPin()){
				// 	System.out.println("\nWelcome " + account[customerNumber].getAccountName());
				// 	end = true;
				// }


				if (!end) {
					System.out.println("\nWrong Customer Number or Pin Number");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Character(s). Only Numbers.");
			}
		}
	}
    
    
}

