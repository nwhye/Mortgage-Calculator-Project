import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static void main() {

        int principal;
        float annualInterest;
        byte years;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }
        while (true){
            System.out.print("Annual Interest Rate:: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }
        while (true){
            System.out.println("Period (years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format( mortgage );
        System.out.println("Mortgage: " + mortgageFormatted);
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
