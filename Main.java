import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    //รับข้อมูล
        ATM atm = new ATM();   //สร้างatm

        // Step 1: Initialize accounts   กำหนัดจำนวน บช
        System.out.print("Enter the number of accounts to create (max 5): ");
        int numAccounts = scanner.nextInt();
        scanner.nextLine(); // Prevent skipping next input

        if (numAccounts > 5) {   // เกิน 5 บช ระบบปรับให้เป็น 5 บช
            System.out.println("Maximum account limit is 5. Setting to 5.");
            numAccounts = 5;
        }

        for (int i = 0; i < numAccounts; i++) {  //ลูป ข้อมูลที่ใส่สร้างบช
            System.out.println("Enter details for account #" + (i + 1));
            System.out.print("Account ID: ");
            String accountID = scanner.nextLine();
            System.out.print("Account Name: ");
            String accountName = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("Initial Balance (max 1,000,000): ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Prevent skipping next input

            if (balance > 1000000) {   // เกิน1ล้านปรับให้เป็น1ล้าน
                System.out.println("Balance exceeds limit. Setting to 1,000,000.");
                balance = 1000000;
            }

            BankAccount account = new BankAccount(accountID, accountName, password, balance);
            atm.addAccount(account);     //เพิ่มข้อมูล
        }

        // Step 2: Start ATM interaction      ลูปatm ใส่ชื่อบช เเละ รหัส
        while (true) {
            System.out.println("\nATM ComputerThanyaburi Bank");
            System.out.print("Account ID: ");
            String accountID = scanner.nextLine();
            System.out.print("Account Password: ");
            String password = scanner.nextLine();

            BankAccount account = atm.authenticate(accountID, password);
            if (account != null) {
                atm.displayMenu(account, scanner);
            } else {
                System.out.println("Invalid account ID or password. Try again.");
            }
        }
    }
}

