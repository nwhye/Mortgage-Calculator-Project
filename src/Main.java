import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static void main() {

        int principal = (int)readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float)readNumber("Annual Interest: ", 1, 30);
        byte years = (byte)readNumber("Period (years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format( mortgage );
        System.out.println("Mortgage: " + mortgageFormatted);
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

            final byte MONTH_IN_YEAR = 12;
            final byte PERCENT = 100;
            short numbersOfPayments = (short)(years * MONTH_IN_YEAR);
            float monthlyInterest = (float) (annualInterest / PERCENT / MONTH_IN_YEAR);

            double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments)
                    / (Math.pow(1 + monthlyInterest, numbersOfPayments) - 1));
            return mortgage;
    }

}
