public class Main {

    static void main() {
        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MorgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
