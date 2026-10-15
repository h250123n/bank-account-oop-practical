public class SavingsAccount extends Account {

    private static final double MINIMUM_BALANCE = 100.00;
    private static final double MONTHLY_INTEREST_RATE = 0.02;

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(accountNumber + ": withdrawal must be positive.");
            return;
        }
        if (balance - amount < MINIMUM_BALANCE) {
            System.out.printf("%s: withdrawal of %.2f REJECTED. Balance cannot fall below the minimum of %.2f.%n",
                    accountNumber, amount, MINIMUM_BALANCE);
            return;
        }
        balance -= amount;
        System.out.printf("%s: withdrew %.2f.%n", accountNumber, amount);
    }

    @Override
    public void endOfMonth() {
        double interest = balance * MONTHLY_INTEREST_RATE;
        balance += interest;
        System.out.printf("%s: interest of %.2f added (%.0f%%).%n",
                accountNumber, interest, MONTHLY_INTEREST_RATE * 100);
    }
}
