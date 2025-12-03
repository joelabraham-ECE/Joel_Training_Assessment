// Parent Class
class BankAccount {
    protected String accountNo;
    protected double balance;

    // Constructor
    public BankAccount(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// Subclass 1: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNo, double balance, double interestRate) {
        super(accountNo, balance);
        this.interestRate = interestRate;
    }

    // Method to add interest
    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest + ". New Balance: " + balance);
    }
}

// Subclass 2: SalaryAccount
class SalaryAccount extends BankAccount {
    private double monthlySalary;

    public SalaryAccount(String accountNo, double balance, double monthlySalary) {
        super(accountNo, balance);
        this.monthlySalary = monthlySalary;
    }

    // Method to credit salary
    public void creditSalary() {
        balance += monthlySalary;
        System.out.println("Salary credited: " + monthlySalary + ". New Balance: " + balance);
    }
}

// Main Class for testing
public class Main {
    public static void main(String[] args) {

        // Savings Account Testing
        SavingsAccount sa = new SavingsAccount("SA123", 5000, 5);
        sa.deposit(1000);
        sa.addInterest();
        sa.withdraw(2000);

        System.out.println();

        // Salary Account Testing
        SalaryAccount salAcc = new SalaryAccount("SAL456", 2000, 30000);
        salAcc.creditSalary();
        salAcc.withdraw(5000);
    }
}
