import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static void main() {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal;
        float monthlyInterest;
        int numbersOfPayments;

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
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        while (true){
            System.out.println("Period (years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numbersOfPayments = years * MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments)  / (Math.pow(1 + monthlyInterest, numbersOfPayments) - 1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format( mortgage );
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
