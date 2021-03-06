import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BankAccountTest {

    @Test
    void makeADeposit() throws ParseException {
        Date date = convertToDate("11/01/2022");
        Amount one = Amount.of(1);
        BankAccount john = new BankAccount();
        assertEquals("DEPOSIT, 11/01/2022, 1.00, 1.00", john.deposit(one, date));
    }

    @Test
    void makeADoubleDeposit() throws ParseException {
        Date date = convertToDate("18/01/2022");
        Amount one = Amount.of(1);

        BankAccount eddie = new BankAccount();
        assertEquals("DEPOSIT, 18/01/2022, 1.00, 1.00", eddie.deposit(one, date));

        assertEquals("DEPOSIT, 18/01/2022, 1.00, 2.00", eddie.deposit(one, date));
    }

    @Test
    void makeAWithdraw() throws ParseException {
        Date date = convertToDate("20/01/2022");
        Amount sixty_five = Amount.of(65);
        BankAccount bart = new BankAccount();

        assertEquals("DEPOSIT, 20/01/2022, 65.00, 65.00", bart.deposit(sixty_five, date));

        Amount thirty_three = Amount.of(33);

        assertEquals("WITHDRAWAL, 20/01/2022, 33.00, 32.00", bart.withdraw(thirty_three, date));
    }

    @Test
    void makeMultipleWithdraw() throws ParseException {
        BankAccount joe = new BankAccount();
        Date date = convertToDate("21/01/2022");
        Amount sixty_five = Amount.of(65);
        joe.deposit(sixty_five, date);

        Amount nThirty_three = Amount.of(33);
        assertEquals("WITHDRAWAL, 21/01/2022, 33.00, 32.00", joe.withdraw(nThirty_three, date));

        Amount nTwelve = Amount.of(12);
        assertEquals("WITHDRAWAL, 21/01/2022, 12.00, 20.00", joe.withdraw(nTwelve, date));
    }

    private Date convertToDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
    }

    @Test
    void showHistory() throws ParseException {
        BankAccount doe = new BankAccount();
        Amount twenty_three = Amount.of(23);
        Date date = convertToDate("22/01/2022");

        doe.deposit(twenty_three, date);
        assertEquals(List.of("DEPOSIT, 22/01/2022, 23.00, 23.00"), doe.history());
    }

    @Test
    void showSeveralOperationHistory() throws ParseException {
        BankAccount jane = new BankAccount();
        Date date = convertToDate("21/01/2022");
        Amount twenty_three = Amount.of(23);
        Amount ten = Amount.of(10);
        jane.deposit(twenty_three, date);
        jane.withdraw(ten, date);
        jane.withdraw(ten, date);
        jane.withdraw(ten, date);
        assertEquals(Arrays.asList(
                "WITHDRAWAL, 21/01/2022, 10.00, -7.00",
                "WITHDRAWAL, 21/01/2022, 10.00, 3.00",
                "WITHDRAWAL, 21/01/2022, 10.00, 13.00",
                "DEPOSIT, 21/01/2022, 23.00, 23.00"
                ), jane.history());
    }

}
