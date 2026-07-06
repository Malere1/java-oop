
public class BankAccount {

    private String accountName;
    private int pin;
    private double balance;

    public BankAccount(String accountName, int pin, double balance) {
        this.accountName = accountName;
        this.pin = pin;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public double getBalance(int enteredPin) {
        if (enteredPin != pin) {
            throw new IllegalArgumentException("Incorrect PIN.");
        }
        return balance;
    }
    public void withdraw(double amount, int enteredPin) {

        if (enteredPin != pin) {
            throw new IllegalArgumentException("Incorrect PIN.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        balance -= amount;
    }
    public void changePin(int oldPin, int newPin) {

        if (oldPin != pin) {
            throw new IllegalArgumentException("Incorrect old PIN.");
        }

        pin = newPin;
    }

}

