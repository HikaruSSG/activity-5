import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BankingSystem {

    private static List<String> accountNames = new ArrayList<>();
    private static List<Double> balances = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int currentAccountIndex = -1;
    private static final String ACCOUNTS_FILE = "accounts.json";

    public static void main(String[] args) {
        loadData();
        displayMenu();
        saveData();
    }

    public static void displayMenu() {
        int choice;
        do {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Select Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    selectAccount();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    withdrawMoney();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    System.out.println("Exiting Banking System. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    public static void createAccount() {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();
        accountNames.add(accountName);
        balances.add(0.0);
        System.out.println("Account created successfully for " + accountName + ".");
    }

    public static void selectAccount() {
        if (accountNames.isEmpty()) {
            System.out.println("No accounts exist. Please create an account first.");
            return;
        }
        System.out.println("Available accounts:");
        for (int i = 0; i < accountNames.size(); i++) {
            System.out.println((i + 1) + ". " + accountNames.get(i));
        }
        System.out.print("Enter the number of the account to select: ");
        int accountIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        if (accountIndex < 0 || accountIndex >= accountNames.size()) {
            System.out.println("Invalid account number.");
            return;
        }

        currentAccountIndex = accountIndex;
        System.out.println("Account selected: " + accountNames.get(currentAccountIndex));
    }

    public static void depositMoney() {
        if (currentAccountIndex == -1) {
            System.out.println("Please select an account first.");
            return;
        }
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (depositAmount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balances.set(currentAccountIndex, balances.get(currentAccountIndex) + depositAmount);
        System.out.println("Deposit successful. Current balance: " + balances.get(currentAccountIndex));
    }

    public static void withdrawMoney() {
        if (currentAccountIndex == -1) {
            System.out.println("Please select an account first.");
            return;
        }
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        if (withdrawAmount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (withdrawAmount > balances.get(currentAccountIndex)) {
            System.out.println("Insufficient balance.");
            return;
        }
        balances.set(currentAccountIndex, balances.get(currentAccountIndex) - withdrawAmount);
        System.out.println("Withdrawal successful. Current balance: " + balances.get(currentAccountIndex));
    }

    public static void checkBalance() {
        if (currentAccountIndex == -1) {
            System.out.println("Please select an account first.");
            return;
        }
        System.out.println("Account Name: " + accountNames.get(currentAccountIndex));
        System.out.println("Current Balance: " + balances.get(currentAccountIndex));
    }

    public static void loadData() {
        File accountsFile = new File(ACCOUNTS_FILE);
        if (!accountsFile.exists()) {
            return;
        }

        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(ACCOUNTS_FILE)) {
            JSONArray accountsJson = (JSONArray) parser.parse(reader);

            for (Object accountObj : accountsJson) {
                JSONObject accountJson = (JSONObject) accountObj;
                String accountName = (String) accountJson.get("name");
                Double balance = (Double) accountJson.get("balance");
                accountNames.add(accountName);
                balances.add(balance);
            }
        } catch (IOException | ParseException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    public static void saveData() {
        JSONArray accountsJson = new JSONArray();
        for (int i = 0; i < accountNames.size(); i++) {
            JSONObject accountJson = new JSONObject();
            accountJson.put("name", accountNames.get(i));
            accountJson.put("balance", balances.get(i));
            accountsJson.add(accountJson);
        }

        try (FileWriter writer = new FileWriter(ACCOUNTS_FILE)) {
            writer.write(accountsJson.toJSONString());
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
