import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountName, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account number already exists.");
            return;
        }
        Account account = new Account(accountNumber, accountName, initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully.");
    }

    public Account selectAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            return accounts.get(accountNumber);
        } else {
            System.out.println("Account not found.");
            return null;
        }
    }

    public void depositMoney(String accountNumber, double amount) {
        Account account = selectAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        }
    }

    public void withdrawMoney(String accountNumber, double amount) {
        Account account = selectAccount(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            }
        }
    }

    public void checkBalance(String accountNumber) {
        Account account = selectAccount(accountNumber);
        if (account != null) {
            System.out.println("Account balance: " + account.getBalance());
        }
    }
}
