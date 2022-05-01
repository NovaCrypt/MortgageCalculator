import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // MORTGAGE CALCULATOR
        // OLIVER HUNTER

        // This mortgage calculator takes the total value of the loan, it then takes the term the mortgage will be
        // paid back over and applies 12.89% APR to the loan, then returns the amount owed monthly.

        // CONSTANT VARIABLES

        final float ANNUAL_INTEREST = 12.89F; // The annual APR interest rate. (Percentage)
        final byte PERCENT = 100; // Percent for percentage conversion
        final byte MONTHS_IN_YEAR = 12; // How many months in a year

        // USER INPUTS

        Scanner input = new Scanner(System.in); // Create scanner for reading data input

        float principle; // Define principle variable in main scope
        while (true) { // Begin validation loop for principle
            System.out.print("Principle: £"); // Prompt for the principal amount
            principle = input.nextFloat(); // Read data input for principle
            if (principle < 1_000.0) { // Exception if principle is lover than £1k
                System.out.println("Our minimum loan is £1,000...");
            } else if (principle > 1_000_000.0) { // Exception if principle is greater than £1 million
                System.out.println("We only provide loans up to £1,000,000...");
            } else break; // Break loop if valid
        }

        short term; // Define term variable in main scope
        while (true) { // Begin validation loop
            System.out.print("Period (Months): "); // Prompt for term of the loan
            term = input.nextShort(); // Read data input for term of loan
            if (term < 6) { // Exception is term is shorter than 6 months
                System.out.println("We have a minimum term of 6 months...");
            } else if (term > 600) { // Exception is term is longer than 50 years
                System.out.println("We have a maximum term of 50 years (600 months)...");
            } else break; // Break loop if valid
        }

        // INTEREST CALCULATION

        float monthlyInterest = ANNUAL_INTEREST / PERCENT / MONTHS_IN_YEAR; // Calculate monthly interest rate
        double mortgage = principle // Calculate monthly mortgage payments
                * (monthlyInterest * Math.pow(1 + monthlyInterest, term))
                / (Math.pow(1+ monthlyInterest, term) - 1);

        // MONTHLY PAYBACKS

        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
        // ^ - Prints out monthly payments owed

    }
}