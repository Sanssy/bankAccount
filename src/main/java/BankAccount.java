import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount {

    private final List<String> statements = new ArrayList<>();

    private Amount balance;

    public BankAccount() {
        balance = Amount.of(0);
    }

    public String deposit(Amount amount, Date date) {
        String operation = "DEPOSIT";
        return recordTransaction(date, amount, operation);
    }

    public String withdraw(Amount amount, Date date) {
        String operation = "WITHDRAWAL";
        return recordTransaction(date, amount, operation);
    }

    public String recordTransaction(Date date, Amount amount, String operation) {
        Transaction t = new Transaction(date, amount);
        Amount updatedBalance = t.updateBalance(balance);
        balance = updatedBalance;
        
        String d = new SimpleDateFormat("dd/MM/yyyy").format(date);
        String formattedAmount = amount.decimalFormat();
        String formattedBalance = updatedBalance.decimalFormat();
        String statement = operation + ", " + d + ", " + formattedAmount + "e, " + formattedBalance + "e";
        statements.add(statement);
        return statement;
    }

    public List<String> history() {
        return statements;
    }
}
