
import java.util.HashMap;

public class ATM {
    private HashMap<String, BankAccount> accounts;

    // Constructor
    public ATM() {
        this.accounts = new HashMap<>();
    }

    // Add account to the system
    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountID(), account);
    }

    // Authenticate account by ID and password
    public BankAccount authenticate(String accountID, String password) {
        BankAccount account = accounts.get(accountID);
        if (account != null && account.authenticate(password)) {
            return account;
        }
        return null;
    }

    // Display ATM menu
    public void displayMenu(BankAccount account, java.util.Scanner scanner) {
        while (true) {
            System.out.println("\nATM ComputerThanyaburi Bank");
            System.out.println("Account ID: " + account.getAccountID());
            System.out.println("Menu Service");
            System.out.println("1. Account Balance");
            System.out.println("2. Withdrawal");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Prevent skipping next input

            if (choice == 1) {      
                System.out.println("Balance: " + account.getBalance());
            } else if (choice == 2) {
                System.out.print("Enter withdrawal amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Prevent skipping next input
                if (account.withdraw(amount)) {
                    System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
                } else {
                    System.out.println("Insufficient balance or invalid amount.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting to main menu...");
                break; // Exit menu loop
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
