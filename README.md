### MortgageCalculator-jf

### March 28, 2016

My sixth version controlled project

Create an application which calculates the mortgage of a house given the principle, interest and term. The application should do the following steps:

Welcome the user to the application.
Ask the user what the property ID is.
Ask the user what the principle is (ex: 200000), the interest (ex: .0575), and term in months (360).
Calculate the payments based on the formula below:
double monthlyPayment =  (principle * interest) /  (1 - Math.pow( 1 + interest, -termInMonths));

M = P [ i(1 + i)n ] / [ (1 + i)n - 1]

Where M is the monthly payment. i = r/12. The same formula can be expressed many different way, but this one avoids using negative exponentials which confuse some calculators.

Let the user know what the payments would be each month, for how many years and months for what property. Not just total months based on supplied term (Must use modulus operator).
Ask the user if they would like to find out the mortgage of another home and if not, exit.
Echo a farewell message to the user.
Exit the application.

NOTE:
* To compare Strings you must use equals method or equalsIgnoreCase(). For example:
if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {... pg 70, Java24Hrs

[Mikias Ayalew](http://sqasolution.com)
