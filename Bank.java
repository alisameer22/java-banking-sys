import java.util.HashMap;

public class Bank {
    private HashMap<String, Account> accounts;
    private int accountCounter;
    public Bank() {
        this.accounts =  new HashMap<>();
        this.accountCounter = 1; // Starting account number
    }
    private String generateAccountNumber() {
        String accountnum = String.format("%05d", accountCounter);
        accountCounter++;
        return accountnum;
    }
    public String createAccount(String ownerName, String pinNumber, double initialBalance) {
        String accountNumber = generateAccountNumber();
        Account newAccount = new Account(accountNumber, ownerName, pinNumber, initialBalance);
        accounts.put(accountNumber, newAccount);
        return accountNumber;
    }
    public Account login(String accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        if(account != null && account.verifyPin(pin)){
            return account;
        } else {
            System.out.println("Invalid account number or PIN.");
            return null;
        }
    }
    
}
