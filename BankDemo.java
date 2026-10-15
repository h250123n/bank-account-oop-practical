import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 1000.00));
        accounts.add(new SavingsAccount("SAV-002", 150.00));
        accounts.add(new CurrentAccount("CUR-001", 500.00, 300.00));
        accounts.add(new CurrentAccount("CUR-002", 200.00, 500.00));

        System.out.println("=== Opening balances ===");
        for (Account a : accounts) {
            System.out.println(a);
        }

        System.out.println("\n=== Deposit validation ===");
        try {
            accounts.get(0).deposit(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        accounts.get(0).deposit(200.00);
        System.out.println(accounts.get(0));

        System.out.println("\n=== Withdraw 300 from every account ===");
        for (Account a : accounts) {
            a.withdraw(300.00);
            System.out.println("   -> " + a);
        }

        System.out.println("\n=== Withdraw 800 from every account (beyond overdraft limits) ===");
        for (Account a : accounts) {
            a.withdraw(800.00);
            System.out.println("   -> " + a);
        }

        System.out.println("\n=== End of month ===");
        for (Account a : accounts) {
            a.endOfMonth();
            System.out.println("   -> " + a);
        }
    }
}
