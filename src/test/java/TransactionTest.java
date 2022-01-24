import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionTest {

    @Test
    void showADeposit() throws ParseException {
        Date depositDate = convertToDate("11/01/2022");
        Transaction deposit = new Transaction(depositDate, Amount.of(100));

        assertEquals("11/01/2022, 100.00, 100.00", deposit.view(Amount.of(100)));
    }

    @Test
    void showAWithdrawal() throws ParseException {
        Date withDrawDate = convertToDate("12/01/2022");
        Transaction withdraw = new Transaction(withDrawDate, Amount.negative(100));

        assertEquals("12/01/2022, -100.00, -100.00", withdraw.view(Amount.negative(100)));
    }

    @Test
    void updateBalanceAfterDeposit() throws ParseException {
        Date depositDate = convertToDate("14/01/2022");
        Transaction deposit = new Transaction(depositDate, Amount.of(1100));

        Amount currentBalance = deposit.updateBalance(Amount.of(200));

        assertEquals(Amount.of(1300), currentBalance);
    }

    @Test
    void updateBalanceAfterWithdrawal() throws ParseException {
        Date withdrawalDate = convertToDate("14/01/2022");
        Transaction withdrawal = new Transaction(withdrawalDate, Amount.of(1000));

        Amount currentBalance = withdrawal.updateBalance(Amount.negative(400));

        assertEquals(Amount.of(600), currentBalance);
    }

    private Date convertToDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
    }

}
