import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction {

    private final String DATE_STANDARD_FORMAT = "dd/MM/yyyy";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_STANDARD_FORMAT);

    private final Date date;

    private final Amount amount;

    public Transaction(Date date, Amount amount) {
        this.date = date;
        this.amount = amount;
    }

    public String view(Amount currentBalance) {
        String separator = ", ";
        return dateFormat.format(date) +
                separator +
                amount.decimalFormat() +
                separator +
                currentBalance.decimalFormat();
    }

    public Amount updateBalance(Amount amount) {
        return this.amount.add(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction that)) return false;
        return Objects.equals(date, that.date) && Objects.equals(amount, that.amount);
    }
}
