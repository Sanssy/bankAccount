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
        return recordTransaction(date, amount, OperationType.DEPOSIT);
    }

    public String withdraw(Amount amount, Date date) {
        return recordTransaction(date, amount, OperationType.WITHDRAWAL);
    }

    public String recordTransaction(Date date, Amount amount, OperationType operation) {
        Transaction transaction = new Transaction(date, amount, operation);
        Amount updatedBalance = transaction.updateBalance(balance, operation);
        balance = updatedBalance;
        return transaction.view(updatedBalance);
    }

    public List<String> history() {
        return statements;
    }
}
