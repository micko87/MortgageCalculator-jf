import java.util.Scanner;

/**
 *   File Name: SavingsCalculator.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Mar 29, 2016
 *
 */

/**
 * SavingsCalculator //ADDD (description of class)
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
public class SavingsCalculator {

	static double compoudInterestPercent;
	static double depositAmount;
	static double initialAmount;
	static double monthlyInterest;
	static double savingsExtraPerMonth;
	static Scanner scanner = new Scanner(System.in);
	static String userNmae;

	// Calculate interest for periods a year (12 months) plus any deposits and
	// return new balance
	public static double calcInterestAndDepositsPerPeriod(double balance, double monthlyDepositAmount,
			double annualInterestPercent, double periodsPerYear) {
		double monthlyInterest = (annualInterestPercent / 100) / periodsPerYear;
		double additionalAmount = (monthlyInterest * balance) + monthlyDepositAmount;
		return additionalAmount;
		// Cumulative total
	}

	// Calculate Yearly Total
	public static double calculateCumulativeTotalCompoundedMonthly(double baseAmount, double monthlyDepositAmount,
			double annualInterestPercent, int totalTermInMonths) {
		double balance = baseAmount;
		int curYear = 1;
		for (int curTermInMonthsForPeriod = 1; curTermInMonthsForPeriod <= totalTermInMonths; curTermInMonthsForPeriod++) {
			balance += calcInterestAndDepositsPerPeriod(balance, 100, 6.5, 12);
			if (curTermInMonthsForPeriod % 12 == 0) {
				System.out.println(String.format("Year %d: $%,.2f", curYear, balance));
				curYear++;
			}
		}
		return balance;
	}

	public static void main(String[] args) {

		WelcomeUserToApp();

		while (requestToContinue()) {
			getValuesFromUser();
			// calculatePayments();
			displayPayments();
		}

		farewellUser();

	}

	// /**
	// *
	// */
	// private static void calculatePayments() {
	// //
	// System.out.println("Calculate payments:\n--------------");
	// int compoundInterestPercent = 0;
	// double monthlyInterest = (compoundInterestPercent / 100) / 12;
	// double savingsExtraPerMonth = (initialAmount * monthlyInterest) +
	// depositAmount;
	//
	// }

	/**
	 *
	 */
	private static void displayPayments() {
		//
		System.out.println("Display payments:\n---------------");
		double newBalance = calculateCumulativeTotalCompoundedMonthly(10000, 100, 6.5, 120);
		System.out.println(
				"Based on your input values, it seems you will have the following in your savings account within the next 10 years: "
						+ newBalance);

	}

	/**
	 *
	 */
	private static void farewellUser() {
		//
		System.out.println("Farewell User:\n--------------");
		System.out.println("Thank you " + userNmae + "for using saving calculator application");
		scanner.close();

	}

	/**
	 *
	 */
	private static void getValuesFromUser() {
		//
		System.out.println("Request values from user:\n---------------");

		System.out.println("How much do you currently have in your savings account?");
		String input = scanner.nextLine();
		initialAmount = Double.parseDouble(input);

		System.out.println("What will be your monthly payments into your account?");
		input = scanner.nextLine();
		depositAmount = Double.parseDouble(input);

		System.out.println("What is your annually compounded interest rate?");
		input = scanner.nextLine();
		compoudInterestPercent = Double.parseDouble(input);

		System.out.println("How many years would you like to calculate?");
		input = scanner.nextLine();
		savingsExtraPerMonth = Double.parseDouble(input);
		// Years
	}

	/**
	 * @return
	 */
	private static boolean requestToContinue() {

		System.out.println("Request To Continue:\n-------------");

		while (true) {
			System.out.println("Would like to calculate another saving account");
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
		//
		System.out.println("Welcome to Saving Calculator Application. ");
		System.out.println("Can I get your name please ");
		String userName = scanner.next();

	}

}
