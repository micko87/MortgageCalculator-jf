import java.util.Scanner;

/**
 *   File Name: MortgageCalculator.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Mar 28, 2016
 *
 */

/**
 * MortgageCalculator //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 *
 */

public class MortgageCalculator {

	static double interest;
	static double monthlyPayment;
	static double principle;
	static String propertyID;
	static Scanner scanner = new Scanner(System.in);
	static double termInMonths;
	static String userName;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		WelcomeUserToApp();

		while (requestToContinue()) {

			getValuesFromUser();
			calculatePayments();
			displayPayments();
			farewellUser();

		}
		farewellUser();

	}

	/**
	 *
	 */
	private static void calculatePayments() {
		System.out.println("Calculate payment:\n-----------------");
		monthlyPayment = (principle * interest) / (1 - Math.pow(1 + interest, -termInMonths) * 100 / 100);

	}

	/**
	 *
	 */

	private static void displayPayments() {
		System.out.println("Display Payments:\n-----------------");
		System.out.println("Your monhtly payment will be " + monthlyPayment + " per month for "
				+ Math.floor(termInMonths / 12) + " years and " + termInMonths % 12 + " months");
	}

	/**
	 *
	 */
	private static void farewellUser() {
		System.out.println("Farewell User:\n--------------------");
		System.out.println("Thank you " + userName + "for using the mortgage calculator application");
		scanner.close();
	}

	/**
	 *
	 */
	private static void getValuesFromUser() {
		System.out.println("Request Values From User:\n------------");

		System.out.println("What is your property ID to Calculate the mortgage for:");
		String input = scanner.nextLine();
		propertyID = input;

		System.out.println("What is " + propertyID + "'s principle:");
		input = scanner.nextLine();
		principle = Double.parseDouble(input);

		System.out.println("What is " + propertyID + "'s interest:");
		input = scanner.nextLine();
		interest = Double.parseDouble(input);

		System.out.println("What is " + propertyID + "'s term in months:");
		input = scanner.nextLine();
		termInMonths = Double.parseDouble(input);

	}

	/**
	 * @return
	 */
	private static boolean requestToContinue() {
		System.out.println("Request To Continue:\n---------------");
		while (true) {
			System.out.println("Would you like to calculate another mortgage");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("Y")) {
				return true;
			} else if (input.equalsIgnoreCase("No") || input.equalsIgnoreCase("N")) {
				return false;
			} else {
				System.out.println("Invalid option (" + input + "), please use Yes/Y or No/N.");

			}
		}

	}

	/**
	 *
	 */
	private static void WelcomeUserToApp() {

		System.out.println("Welcome to the Mortgage Calcaulator Application. ");
		System.out.print("Hello, could I please get your name?  ");

	}

}
