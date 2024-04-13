import java.util.Scanner;

class ATM {
    private String userID;
    private String pin;
    private double balance;

    public ATM(String userID, String pin, double balance) {
        this.userID = userID;
        this.pin = pin;
        this.balance = balance;
    }

    public void displayMenu() {
        System.out.println("Welcome, " + userID + "!");
        System.out.println("1. Transaction History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void showTransactionHistory() {
        // Implementation for displaying transaction history
        System.out.println("Transaction History:");
        // Display transaction history here
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void transfer(String recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Transfer of $" + amount + " to " + recipient + " successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        // Sample user ID and pin
        String userID = "user123";
        String pin = "1234";
        double initialBalance = 1000.00; // Initial balance for the user

        ATM atm = new ATM(userID, pin, initialBalance);
        Scanner scanner = new Scanner(System.in);

        // Prompt user for user ID and pin
        System.out.println("Enter User ID:");
        String inputUserID = scanner.nextLine();

        System.out.println("Enter PIN:");
        String inputPin = scanner.nextLine();

        // Verify user ID and pin
        if (inputUserID.equals(userID) && inputPin.equals(pin)) {
            System.out.println("Authentication successful.");
            boolean isRunning = true;

            while (isRunning) {
                atm.displayMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        atm.showTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient: ");
                        String recipient = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        atm.transfer(recipient, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
        }
        scanner.close();
    }
}
