import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BankingApplication {

    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    private static void createAccount() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter account holder name: ");
        String accountHolderName = sc.nextLine();

        if (accounts.containsKey(accountNumber)){
            System.out.println("Account already exists with this account number.");
        } else {
            Account account = new Account(accountNumber, accountHolderName);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully.");
        }
    }

    private static void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void balanceInquiry() {
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void main(String[] args) {

        boolean exit = false;
        while (!exit) {
            System.out.println("\n\n\n\n\t\t\t\t\t\tWelcome to the Banking Application");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Inquiry");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    balanceInquiry();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Banking Application.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
