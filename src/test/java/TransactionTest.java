import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionTest {

    @Test
    void showADeposit() throws ParseException {
        Date depositDate = convertToDate("11/01/2022");
        Transaction deposit = new Transaction(depositDate, Amount.of(100), OperationType.DEPOSIT);

        assertEquals("DEPOSIT, 11/01/2022, 100.00, 100.00", deposit.view(Amount.of(100)));
    }

    @Test
    void showAWithdrawal() throws ParseException {
        Date withDrawDate = convertToDate("12/01/2022");
        Transaction transaction = new Transaction(withDrawDate, Amount.negative(100), OperationType.WITHDRAWAL);

        assertEquals("WITHDRAWAL, 12/01/2022, -100.00, -100.00", transaction.view(Amount.negative(100)));
    }

    @Test
    void updateBalanceAfterDeposit() throws ParseException {
        Date depositDate = convertToDate("14/01/2022");
        OperationType deposit = OperationType.DEPOSIT;
        Transaction transaction = new Transaction(depositDate, Amount.of(1100), deposit);

        Amount currentBalance = transaction.updateBalance(Amount.of(200), deposit);

        assertEquals(Amount.of(1300), currentBalance);
    }

    @Test
    void updateBalanceAfterWithdrawal() throws ParseException {
        Date withdrawalDate = convertToDate("14/01/2022");
        OperationType withdrawal = OperationType.WITHDRAWAL;
        Transaction transaction = new Transaction(withdrawalDate, Amount.of(400), withdrawal);

        Amount currentBalance = transaction.updateBalance(Amount.of(1000), withdrawal);

        assertEquals(Amount.of(600), currentBalance);
    }

    private Date convertToDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
    }

}
