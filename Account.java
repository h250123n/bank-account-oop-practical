public abstract class Account {

    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);

    public abstract void endOfMonth();

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f",
                accountNumber, getClass().getSimpleName(), balance);
    }
}
