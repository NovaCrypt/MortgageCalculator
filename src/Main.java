import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! This application is in early alpha.");

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

        System.out.print("Principle: £"); // Prompt for the principal amount
        float principle = input.nextFloat(); // Read data input for principle

        System.out.print("Period (Months): "); // Prompt for term of the loan
        byte term = input.nextByte(); // Read data input for term of loan

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