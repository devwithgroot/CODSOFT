import java.util.Scanner;


class BankAccount {
    private double balance;

    // Constructor to initialize the account with a starting balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f. New balance: $%.2f\n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f. New balance: $%.2f\n", amount, balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance for this withdrawal.");
            return false;
        } else {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    // Constructor to connect the ATM to a user's bank account
    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the main menu and handle user choices
    public void showMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");

            // Input validation for menu choice
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 4.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Method to check the account balance
    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", userAccount.getBalance());
    }

    // Method to handle deposits
    private void deposit() {
        System.out.print("Enter the amount to deposit: $");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            userAccount.deposit(amount);
        } else {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
    }

    // Method to handle withdrawals
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: $");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            userAccount.withdraw(amount);
        } else {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
    }
}

// Main class to run the ATM application
public class AtmInterface {
    public static void main(String[] args) {
        // Create a new bank account with an initial balance of $1000
        BankAccount account = new BankAccount(1000.00);
        
        // Create an ATM instance connected to the user's account
        ATM atm = new ATM(account);
        
        // Start the ATM by showing the menu
        atm.showMenu();
    }
}
