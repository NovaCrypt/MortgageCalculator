import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // MORTGAGE CALCULATOR
        // OLIVER HUNTER

        // This mortgage calculator takes the total value of the loan, it then takes the term the mortgage will be
        // paid back over and applies 12.89% APR to the loan, then returns the amount owed monthly.

        // CONSTANT VARIABLES

        final byte PERCENT = 100; // Percent for percentage conversion
        final byte MONTHS_IN_YEAR = 12; // How many months in a year

        // USER INPUTS

        Scanner input = new Scanner(System.in); // Create scanner for reading data input

        float principle; // Define principle variable in main scope
        while (true) { // Begin validation loop for principle
            System.out.println("\nPlease provide desired loan amount...\n");
            System.out.print("- £"); // Prompt for the principal amount
            principle = input.nextFloat(); // Read data input for principle
            if (principle < 1_000.0) { // Exception if principle is lover than £1k
                System.out.println("Our minimum loan is £1,000...");
            } else if (principle > 1_000_000.0) { // Exception if principle is greater than £1 million
                System.out.println("We only provide loans up to £1,000,000...");
            } else break; // Break loop if valid
        }

        short term; // Define term variable in main scope
        while (true) { // Begin validation loop
            System.out.println("\nPlease say how many months you'd like to pay your loan back over. (max 600)\n");
            System.out.print("Period (Months): "); // Prompt for term of the loan
            term = input.nextShort(); // Read data input for term of loan
            if (term < 6) { // Exception is term is shorter than 6 months
                System.out.println("We have a minimum term of 6 months...");
            } else if (term > 600) { // Exception is term is longer than 50 years
                System.out.println("We have a maximum term of 50 years (600 months)...");
            } else break; // Break loop if valid
        }

        float annualInterest = 0; // Initialise interest variable
        boolean whileBreak = false; // Provide the while loop breaking variable
        while (!whileBreak) { // Begin validation loop
            System.out.println("\nPlease provide an interest rate for mortgage calculation...\n");
            System.out.print("- %"); // Prompt for annual interest percentage
            annualInterest = input.nextFloat(); // Scan the user input for the annual interest
            if (annualInterest < 0.0F) {
                System.out.println("Please provide a positive number, or none at all...");
            } else if (annualInterest > 80) {
                System.out.println("To prevent death by debt induced shock, we have limited this field to 80%... " +
                        "Sorry for any inconvenience.");
            } else {
                whileBreak = true; // Breaks while loop
            }
        }

        // INTEREST CALCULATION

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR; // Calculate monthly interest rate
        double mortgage = principle // Calculate monthly mortgage payments
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, term))
                    / (Math.pow(1+ monthlyInterest, term) - 1);
        double mortgageTotal = mortgage * term;

        // MONTHLY PAYBACKS

        NumberFormat getCurrency = NumberFormat.getCurrencyInstance();
        System.out.println("Mortgage total (Interest included): " + getCurrency.format(mortgageTotal));
        // ^ - Prints the total owed once interest is applied.
        System.out.println("Monthly total: " + getCurrency.format(mortgage));
        // ^ - Prints out monthly payments owed

    }
}