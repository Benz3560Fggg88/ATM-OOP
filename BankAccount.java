public class BankAccount {
    private String accountID;
    private String accountName;
    private String password;
    private double balance; // ยอดเงิน

    // Constructor
    public BankAccount(String accountID, String accountName, String password, double balance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.password = password;
        this.balance = balance;
    }

    // Getter for accountID คืนค่า บช
    public String getAccountID() {
        return accountID;
    }

    // Authenticate the user ตรวจรหัสผ่าน
    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Get the balance คืนค่ายอดเงิน
    public double getBalance() {
        return balance;
    }

    // Withdraw money   ต้องการถอนเงิน
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
