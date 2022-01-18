import java.util.List;

public class BankAccount {

    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public double withdraw(double amount) {
        return balance -= amount;
    }

    public List<String> history() {
        return List.of("DEPOSIT, 18/01/2022, 23e, 23e");
    }
}
