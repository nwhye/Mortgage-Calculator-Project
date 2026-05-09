import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static void main() {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate:: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR ;

        System.out.println("Period (years): ");
        byte years = scanner.nextByte();
        int numbersOfPayments = years * MONTH_IN_YEAR;

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments)  / (Math.pow(1 + monthlyInterest, numbersOfPayments) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format( mortgage );
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
