import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the account balance
    public double getBalance() {
        return balance;
    }

    // Method to withdraw from the account
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false; // Withdrawal failed due to insufficient funds
        } else if (amount <= 0) {
            return false; // Invalid amount for withdrawal
        } else {
            balance -= amount;
            return true; // Withdrawal successful
        }
    }

    // Method to deposit into the account
    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false; // Invalid amount for deposit
        } else {
            balance += amount;
            return true; // Deposit successful
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;

    // Constructor that links the ATM to a user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method for withdrawing money
    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Amount withdrawn: $" + amount);
        } else {
            System.out.println("Withdrawal failed! Insufficient funds or invalid amount.");
        }
    }

    // Method for depositing money
    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit successful! Amount deposited: $" + amount);
        } else {
            System.out.println("Deposit failed! Please enter a valid amount.");
        }
    }

    // Method for checking the balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }
}

// Main class to simulate the ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a BankAccount object for the user with an initial balance
        BankAccount userAccount = new BankAccount(1000.00);

        // Create an ATM object linked to the user's bank account
        ATM atm = new ATM(userAccount);

        // User interaction loop
        while (true) {
            System.out.println("\nATM Interface:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
