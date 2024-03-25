package ATM_INTERFACE;
import java.util.*;

class Account {
    private double currentBalance;

    public Account(double initialBalance) {
        this.currentBalance = initialBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void depositAmount(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            System.out.println("Deposit of $" + amount + " successful. Current balance: $" + currentBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdrawAmount(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + currentBalance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

class AutomatedTellerMachine {
    private Account bankAccount;

    public AutomatedTellerMachine(Account bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void showMenu() {
        System.out.println("-----ATM Machine-----");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Current balance: $" + bankAccount.getCurrentBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.depositAmount(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdrawAmount(withdrawalAmount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("<-----Welcome to ATM Machine----->");
        System.out.print("Enter initial account balance: $");
        double initialBalance = scanner.nextDouble();
        Account bankAccount = new Account(initialBalance);

        AutomatedTellerMachine atm = new AutomatedTellerMachine(bankAccount);

        while (true) {
            atm.showMenu();
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            atm.processTransaction(choice, scanner);
        }
    }
}
