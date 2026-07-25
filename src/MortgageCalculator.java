public class MortgageCalculator {
    public final static byte MONTH_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateMortgage() {

        short numbersOfPayments = (short) (years * MONTH_IN_YEAR);
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTH_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numbersOfPayments)
                / (Math.pow(1 + monthlyInterest, numbersOfPayments) - 1));
        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        short numbersOfPayments = (short) (years * MONTH_IN_YEAR);
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTH_IN_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numbersOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPaymentsMade) - 1);

        return balance;
    }

    public short getYears() {
        return years;
    }
}
