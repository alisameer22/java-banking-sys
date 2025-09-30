import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Welcome to the Bank ===");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
            case 1:
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.println("Enter a 4-digit PIN: ");
                String pin = scanner.nextLine();
                System.out.print("Enter initial deposit amount: ");
                double initialDeposit = scanner.nextDouble();
                String accountNumber = bank.createAccount(name, pin, initialDeposit);
                System.out.println("Account created successfully! Your account number is: " + accountNumber);

                break;
            case 2:
                System.out.print("Enter account number: ");
                String loginAccNum = scanner.nextLine();
                System.out.print("Enter PIN: ");
                String loginPin  = scanner.nextLine();
                Account loggedInAccount = bank.login(loginAccNum, loginPin );

                if(loggedInAccount != null) {
                    System.out.println("Login successful!");
                    // Call the account menu method here
                    accountMenu(scanner, loggedInAccount);
                }
                break;
            case 3:
                running = false;
                System.out.println("Thank you for using the bank. Goodbye!");
                break;
            default:
                throw new AssertionError();
        }
        }
        scanner.close();
        
    }
    public static void accountMenu(Scanner scanner, Account account) {
        boolean loggedInAccount = true;
        while (loggedInAccount) {
        System.out.println("\n=== Account Menu ===");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.err.println("4. Display Account Info");
        System.out.println("5. Logout");
        System.out.print("Choose an option: ");

        int Choice = scanner.nextInt();
        scanner.nextLine();

        switch (Choice) {
            case 1:
                System.out.println("Your balance is: $" + String.format("%.2f", account.getBalance()));
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful! New balance: $" + String.format("%.2f", account.getBalance()));
                break;
            case 3:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                account.withdraw(withdrawAmount);
                System.out.println("Withdrawal successful! New balance: $" + String.format("%.2f", account.getBalance()));

                break;
            case 4:
                System.err.println("your account info: ");
                account.displayAccountInfo();
                break;
            case 5:
                loggedInAccount = false;
                System.out.println("Logged out successfully.");
                break;
            default:
                throw new AssertionError();
        }
        }
    }
}