import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

    static void main() {
        int principal = (int)readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float)readNumber("Annual Interest: ", 1, 30);
        byte years = (byte)readNumber("Period (years): ", 1, 30);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(years, principal, annualInterest);
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format( mortgage );
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(byte years, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month < years + MONTH_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextInt();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            double principal,
            double annualInterest,
            byte years) {

            short numbersOfPayments = (short)(years * MONTH_IN_YEAR);
            float monthlyInterest = (float) (annualInterest / PERCENT / MONTH_IN_YEAR);

            double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments)
                    / (Math.pow(1 + monthlyInterest, numbersOfPayments) - 1));
            return mortgage;
    }

    public static double calculateBalance (
            double principal,
            double annualInterest,
            byte years,
            short numberOfPaymentsMade
    ) {
        short numbersOfPayments = (short)(years * MONTH_IN_YEAR);
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTH_IN_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numbersOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPaymentsMade) - 1);

        return balance;
    }
}
