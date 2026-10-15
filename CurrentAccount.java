public class CurrentAccount extends Account {

    private static final double MONTHLY_FEE = 5.00;

    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double openingBalance, double overdraftLimit) {
        super(accountNumber, openingBalance);
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(accountNumber + ": withdrawal must be positive.");
            return;
        }
        if (balance - amount < -overdraftLimit) {
            System.out.printf("%s: withdrawal of %.2f REJECTED. It would exceed the overdraft limit of %.2f.%n",
                    accountNumber, amount, overdraftLimit);
            return;
        }
        balance -= amount;
        if (balance < 0) {
            System.out.printf("%s: withdrew %.2f. Account is now in overdraft.%n", accountNumber, amount);
        } else {
            System.out.printf("%s: withdrew %.2f.%n", accountNumber, amount);
        }
    }

    @Override
    public void endOfMonth() {
        balance -= MONTHLY_FEE;
        System.out.printf("%s: monthly maintenance fee of %.2f deducted.%n", accountNumber, MONTHLY_FEE);
    }
}
