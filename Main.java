import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(); // Create a new Bank object
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object
        String accountNumber; // Account number
        double amount; // Amount
        int choice; // Choice
        Account activeAccount = null; // Active account

        do {
            clearScreen(); // Clear screen

            // Display active account information if an account is currently selected
            if (activeAccount != null) {
                System.out.println("Active Account:"); // Display the label indicating the currently selected account
                System.out.println("Account Number: " + activeAccount.getAccountNumber()); // Display the account number of the active account
                System.out.println("Account Name: " + activeAccount.getAccountName()); // Display the name associated with the active account
                System.out.println(); // Add a newline for better readability
            } // End of if

            System.out.println("Bank System Menu:"); // Print the main menu for the bank system
            System.out.println("1. Create Account"); // Option to create a new bank account
            System.out.println("2. Select Account"); // Option to select an existing bank account
            System.out.println("3. Check Balance"); // Option to check the balance of the selected account
            System.out.println("4. Deposit Money"); // Option to deposit money into the selected account
            System.out.println("5. Withdraw Money"); // Option to withdraw money from the selected account
            System.out.println("6. Log Out"); // Option to log out of the current account
            System.out.println("0. Exit"); // Option to exit the bank system
            System.out.print("Enter your choice: "); // Prompt user to enter their choice

            try {
                choice = scanner.nextInt(); // Get choice
                scanner.nextLine(); // Consume newline
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer."); // Print message
                scanner.nextLine(); // Consume invalid input
                choice = -1; // Set to an invalid choice to loop again
                continue; // Continue
            } // End of try-catch

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: "); // Print message
                    accountNumber = scanner.nextLine(); // Get account number
                    System.out.print("Enter account name: "); // Print message
                    String accountName = scanner.nextLine(); // Get account name
                    System.out.print("Enter initial balance: "); // Print message
                    double initialBalance = scanner.nextDouble(); // Get initial balance
                    scanner.nextLine(); // Consume newline
                    bank.createAccount(accountNumber, accountName, initialBalance); // Create account
                    break; // Break
                case 2:
                    System.out.print("Enter account number: "); // Print message
                    accountNumber = scanner.nextLine(); // Get account number
                    Account selectedAccount = bank.selectAccount(accountNumber); // Select account
                    if (selectedAccount != null) {
                        activeAccount = selectedAccount; // Set active account
                    } // End of if
                    break; // Break
                case 3:
                    if (activeAccount == null) {
                        System.out.println("No account selected. Please select an account first."); // Print message
                        break; // Break
                    } // End of if
                    bank.checkBalance(activeAccount.getAccountNumber()); // Check balance
                    break; // Break
                case 4:
                    if (activeAccount == null) {
                        System.out.println("No account selected. Please select an account first."); // Print message
                        break; // Break
                    } // End of if
                    System.out.print("Enter deposit amount: "); // Print message
                    amount = scanner.nextDouble(); // Get amount
                    scanner.nextLine(); // Consume newline
                    bank.depositMoney(activeAccount.getAccountNumber(), amount); // Deposit money
                    break; // Break
                case 5:
                    if (activeAccount == null) {
                        System.out.println("No account selected. Please select an account first."); // Print message
                        break; // Break
                    } // End of if
                    System.out.print("Enter withdrawal amount: "); // Print message
                    amount = scanner.nextDouble(); // Get amount
                    scanner.nextLine(); // Consume newline
                    bank.withdrawMoney(activeAccount.getAccountNumber(), amount); // Withdraw money
                    break; // Break
                case 6:
                    activeAccount = null; // Log out
                    System.out.println("Logged out successfully."); // Print message
                    break; // Break
                case 0:
                    System.out.println("Exiting..."); // Print message
                    break; // Break
                default:
                    System.out.println("Invalid choice. Please try again."); // Print message
            } // End of switch

            System.out.println("Press Enter to continue..."); // Print message
            scanner.nextLine(); // Consume newline

        } while (choice != 0); // End of do-while

        scanner.close(); // Close scanner
    } // End of main

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Clear screen
        System.out.flush(); // Flush
    } // End of clearScreen
} // End of Main class
