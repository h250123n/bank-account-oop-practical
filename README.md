# Bank Account Practical Assignment (OOP in Java)

**Name:** Roland Machingambi
**Reg Number:** H250123N
**Department:** Software Engineering

## About

A small banking program that demonstrates abstraction, inheritance and polymorphism.
`Account` is an abstract class. `SavingsAccount` and `CurrentAccount` extend it and
override `withdraw()` and `endOfMonth()` with their own rules.

| File | Purpose |
| --- | --- |
| `Account.java` | Abstract base class: `accountNumber`, `balance`, `deposit()`, `getBalance()`, abstract `withdraw()` and `endOfMonth()` |
| `SavingsAccount.java` | Fixed minimum balance (100.00); month-end interest of 2% |
| `CurrentAccount.java` | Overdraft limit; month-end maintenance fee of 5.00 |
| `BankDemo.java` | Loops through a `List<Account>` using only the `Account` reference (no casting) |
| `sample_output.txt` | Output of a run of `BankDemo` |

## How to run

Requires JDK 17 or later.

```
javac *.java
java BankDemo
```

## Edge cases shown in the output

- **Savings withdrawal rejected:** `SAV-002` (balance 150.00) cannot withdraw 300.00 because it would fall below the 100.00 minimum.
- **Current account in overdraft within its limit:** `CUR-002` (balance 200.00, overdraft limit 500.00) withdraws 300.00 and goes to -100.00.
- **Overdraft limit enforced:** `CUR-001` and `CUR-002` reject an 800.00 withdrawal that would pass the overdraft limit.

## Sample output

```
=== Opening balances ===
SAV-001 [SavingsAccount] balance: 1000.00
SAV-002 [SavingsAccount] balance: 150.00
CUR-001 [CurrentAccount] balance: 500.00
CUR-002 [CurrentAccount] balance: 200.00

=== Deposit validation ===
Rejected: Deposit must be positive
SAV-001 [SavingsAccount] balance: 1200.00

=== Withdraw 300 from every account ===
SAV-001: withdrew 300.00.
   -> SAV-001 [SavingsAccount] balance: 900.00
SAV-002: withdrawal of 300.00 REJECTED. Balance cannot fall below the minimum of 100.00.
   -> SAV-002 [SavingsAccount] balance: 150.00
CUR-001: withdrew 300.00.
   -> CUR-001 [CurrentAccount] balance: 200.00
CUR-002: withdrew 300.00. Account is now in overdraft.
   -> CUR-002 [CurrentAccount] balance: -100.00

=== Withdraw 800 from every account (beyond overdraft limits) ===
SAV-001: withdrew 800.00.
   -> SAV-001 [SavingsAccount] balance: 100.00
SAV-002: withdrawal of 800.00 REJECTED. Balance cannot fall below the minimum of 100.00.
   -> SAV-002 [SavingsAccount] balance: 150.00
CUR-001: withdrawal of 800.00 REJECTED. It would exceed the overdraft limit of 300.00.
   -> CUR-001 [CurrentAccount] balance: 200.00
CUR-002: withdrawal of 800.00 REJECTED. It would exceed the overdraft limit of 500.00.
   -> CUR-002 [CurrentAccount] balance: -100.00

=== End of month ===
SAV-001: interest of 2.00 added (2%).
   -> SAV-001 [SavingsAccount] balance: 102.00
SAV-002: interest of 3.00 added (2%).
   -> SAV-002 [SavingsAccount] balance: 153.00
CUR-001: monthly maintenance fee of 5.00 deducted.
   -> CUR-001 [CurrentAccount] balance: 195.00
CUR-002: monthly maintenance fee of 5.00 deducted.
   -> CUR-002 [CurrentAccount] balance: -105.00
```
