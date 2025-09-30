
import java.util.Set;

public class Account {

    private String ownerName;
    private String accountNumber;
    private String pinNumber;
    private double balance;

    public Account(String accountNumber, String ownerName, String pinNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.pinNumber = pinNumber;
        this.balance = initialBalance;
    }
    public double getBalance() {
        return this.balance;
    }
    public void deposit(double amount) {
        if(amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if(amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public boolean verifyPin(String enterdPin){
        if(this.pinNumber.equals(enterdPin)){
            return true;
        } else {
            return false;
        }
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
}
