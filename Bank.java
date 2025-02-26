import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>(); // Initialize accounts map
    } // End of constructor

    public void createAccount(String accountNumber, String accountName, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists."); // Print message
            return; // Return
        }
        Account account = new Account(accountNumber, accountName, initialBalance); // Create account
        accounts.put(accountNumber, account); // Add account to map
        System.out.println("Account created successfully."); // Print message
    } // End of createAccount

    public Account selectAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber); // Return account
        } else {
            System.out.println("Account not found."); // Print message
            return null; // Return null
        }
    } // End of selectAccount

    public void depositMoney(String accountNumber, double amount) {
        Account account = selectAccount(accountNumber); // Select account
        if (account != null) {
            account.deposit(amount); // Deposit money
            System.out.println("Deposit successful. New balance: " + account.getBalance()); // Print message
        }
    } // End of depositMoney

    public void withdrawMoney(String accountNumber, double amount) {
        Account account = selectAccount(accountNumber); // Select account
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: " + account.getBalance()); // Print message
            }
        }
    } // End of withdrawMoney

    public void checkBalance(String accountNumber) {
        Account account = selectAccount(accountNumber); // Select account
        if (account != null) {
            System.out.println("Account balance: " + account.getBalance()); // Print message
        }
    } // End of checkBalance
} // End of Bank class
