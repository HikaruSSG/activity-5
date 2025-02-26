import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        String accountNumber;
        double amount;
        int choice;
        Account activeAccount = null;

        do {
            clearScreen();

            // Display active account information
            if (activeAccount != null) {
                System.out.println("Active Account:");
                System.out.println("Account Name: " + activeAccount.getAccountName());
                System.out.println();
            }

            System.out.println("Bank System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Log In");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit Money");
            System.out.println("5. Withdraw Money");
            System.out.println("6. Log Out");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // Consume invalid input
                choice = -1; // Set to an invalid choice to loop again
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter account name: ");
                    String accountName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    bank.createAccount(accountNumber, accountName, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    Account selectedAccount = bank.selectAccount(accountNumber);
                    if (selectedAccount != null) {
                        activeAccount = selectedAccount;
                    }
                    break;
                case 3:
                    if (activeAccount == null) {
                        System.out.println("No account selected. Please select an account first.");
                        break;
                    }
                    bank.checkBalance(activeAccount.getAccountNumber());
                    break;
                case 4:
                    if (activeAccount == null) {
                        System.out.println("No account selected. Please select an account first.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    bank.depositMoney(activeAccount.getAccountNumber(), amount);
                    break;
                case 5:
                    if (activeAccount == null) {
                        System.out.println("No account selected. Please select an account first.");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    bank.withdrawMoney(activeAccount.getAccountNumber(), amount);
                    break;
                case 6:
                    activeAccount = null;
                    System.out.println("Logged out successfully.");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("Press Enter to continue...");
            scanner.nextLine();

        } while (choice != 0);

        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
