# Simple Bank System

This is a simple bank system implemented in Java. It allows users to create accounts, select accounts, check balances, deposit money, and withdraw money.

## Features

*   Create Account: Allows users to create a new bank account with a unique account number, name, and initial balance.
*   Select Account: Allows users to select an existing account to perform operations on.
*   Check Balance: Allows users to check the balance of their selected account.
*   Deposit Money: Allows users to deposit money into their selected account.
*   Withdraw Money: Allows users to withdraw money from their selected account, with a check to ensure sufficient balance.
*   Log Out: Logs out the currently selected account.

## How to Run

1.  Make sure you have Java installed on your system.
2.  Compile the Java files using the following command:

    ```bash
    javac Account.java Bank.java Main.java
    ```
3.  Run the program using the following command:

    ```bash
    java Main
    ```

    Alternatively, you can use the `coderunner.sh` script to compile and run the program:

    ```bash
    ./coderunner.sh
    ```

## Class Structure

*   `Account`: Represents a bank account with attributes such as account number, name, and balance.
*   `Bank`: Manages the bank accounts, including creating, selecting, depositing, and withdrawing.
*   `Main`: Contains the main method and the menu-driven interface for interacting with the bank system.

## Clear Screen

The program uses the following code to clear the screen:

```java
System.out.print("\033[H\033[2J");
System.out.flush();
```

## Comments

The code contains comments to explain each step.

## Author

Hikaru
