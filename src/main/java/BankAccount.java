import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private double balance;

    private final List<String> statements = new ArrayList<>();

    public BankAccount() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        String operation = "DEPOSIT";
        balance += amount;
        statements.add(recordTransaction(amount, operation));
        return balance;
    }

    public double withdraw(double amount) {
        String operation = "WITHDRAW";
        balance -= amount;
        statements.add(recordTransaction(amount, operation));
        return balance;
    }

    public String recordTransaction(double amount, String operation) {
        double updatedBalance = balance;
        String d = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String formattedAmount = new DecimalFormat("#.##").format(amount);
        String formattedBalance = new DecimalFormat("#.##").format(updatedBalance);
        return operation + ", " + d + ", " + formattedAmount + "e, " + formattedBalance + "e";
    }

    public List<String> history() {
        return statements;
    }
}
