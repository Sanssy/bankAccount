import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction {

    private final String DATE_STANDARD_FORMAT = "dd/MM/yyyy";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_STANDARD_FORMAT);

    private final OperationType operation;

    private final Date date;

    private final Amount amount;

    public Transaction(Date date, Amount amount, OperationType operation) {
        this.date = date;
        this.amount = amount;
        this.operation = operation;
    }

    public String view(Amount currentBalance) {
        String separator = ", ";
        return operation +
                separator +
                dateFormat.format(date) +
                separator +
                amount.decimalFormat() +
                separator +
                currentBalance.decimalFormat();
    }

    public Amount updateBalance(Amount balance, OperationType operation) {
        return switch (operation) {
            case DEPOSIT -> balance.add(this.amount);
            case WITHDRAWAL -> balance.subtract(this.amount);
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(dateFormat, that.dateFormat) && operation == that.operation && Objects.equals(date, that.date) && Objects.equals(amount, that.amount);
    }
}
