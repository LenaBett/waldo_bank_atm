package com.myatm;

import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.Scanner;

public class App {

    private double initialOperatingBalance = 1000;
    private final Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    private void login() {
        // Set the expected password
        String expectedPwd = "Admin123";

        // initialize a boolean variable to compare the initial balance to changes made
        // during transactions
        boolean ispasswordsMatch = false;

        // Prompt user for password
        // Create a loop that gives the user 3 attempts to enter their password before quiting
        for (int counter = 0; counter < 3; counter++) {
            System.out.println("Enter your password");
            String userInput = scanner.nextLine();

            if (expectedPwd.equals(userInput)) {
                ispasswordsMatch = true;
                break;
            }

        }

        // When correct password is provided, the ATM homescreen is displayed
        if (ispasswordsMatch) {
            homeScreen();
        }
    }


    // Homescreen method that provides the user with options
    private void homeScreen() {
        LOGGER.info("****************");
        LOGGER.info("");
        LOGGER.info("ATM SIMULATOR");
        LOGGER.info("");
        LOGGER.info("\"\"\"\"\"\"\"\"\"\"\"\"\"");
        LOGGER.info("");
        LOGGER.info("ATM SERVICES");
        LOGGER.info("");
        LOGGER.info("-------------------");
        LOGGER.info("");
        LOGGER.info("1. Chech Balance");
        LOGGER.info("2. Deposit");
        LOGGER.info("3. Withdraw");
        LOGGER.info("4. Transfer Cash");
        LOGGER.info("5. Quit");
        LOGGER.info("");

        String selectedOption = scanner.nextLine();

        switch (selectedOption) {
            case "1":
                checkBalance();
                break;
            case "2":
                cashDeposit();
                break;
            case "3":
                withdraw();
                break;
            case "4":
                cashTransfer();
                break;
            case "5":
                break;

            default:
                break;
        }
    }

    // Method to check balance
    private void checkBalance() {
        LOGGER.info("Balance is: " + initialOperatingBalance);
        homeScreen();
    }

    //
    private void cashDeposit() {
        LOGGER.info("Enter amount to Deposit: ");

        try {
            double depositAmount = Double.parseDouble(scanner.nextLine());
            initialOperatingBalance += depositAmount;
            checkBalance();

        } catch (Exception e) {
            LOGGER.info("Enter valid amount ");
            withdraw();
        }

    }

    private void withdraw() {
        double WithdrawalCharges = 0.02;
        LOGGER.info("Enter amount to withdraw: ");

        try {
            double withdrawalAmount = Double.parseDouble(scanner.nextLine());
            initialOperatingBalance -= (withdrawalAmount + (withdrawalAmount * WithdrawalCharges));
            checkBalance();

        } catch (Exception e) {
            LOGGER.info("Enter valid amount ");
            withdraw();
        }

    }

    private void cashTransfer() {
        LOGGER.info("Enter amount to transfer: ");

        try {
            double transferAmount = Double.parseDouble(scanner.nextLine());
            initialOperatingBalance -= transferAmount;
            checkBalance();

        } catch (Exception e) {
            LOGGER.info("Enter valid amount ");
            withdraw();
        }
    }


    public static void main(String[] args) {
        App app = new App(); // create an instance of the class
        app.login();

    }
}
