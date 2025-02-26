public class Account {
    private String accountNumber;
    private String accountName;
    private double balance;

    public Account(String accountNumber, String accountName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName; // Assign account name
        this.balance = initialBalance; // Assign initial balance
    } // End of constructor

    public String getAccountNumber() {
        return accountNumber; // Return account number
    } // End of getAccountNumber

    public String getAccountName() {
        return accountName; // Return account name
    } // End of getAccountName

    public double getBalance() {
        return balance; // Return balance
    } // End of getBalance

    public void deposit(double amount) {
        balance += amount; // Deposit money
    } // End of deposit

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount; // Withdraw money
            return true; // Return true
        } else {
            System.out.println("Insufficient balance."); // Print message
            return false; // Return false
        }
    } // End of withdraw

    public void setBalance(double balance) {
        this.balance = balance; // Set balance
    } // End of setBalance
} // End of Account class
