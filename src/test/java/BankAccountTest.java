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
        assertEquals("DEPOSIT, 11/01/2022, 1.00e, 1.00e", john.deposit(one, date));
    }

    @Test
    void makeADoubleDeposit() throws ParseException {
        Date date = convertToDate("18/01/2022");
        Amount one = Amount.of(1);

        BankAccount eddie = new BankAccount();
        assertEquals("DEPOSIT, 18/01/2022, 1.00e, 1.00e", eddie.deposit(one, date));

        assertEquals("DEPOSIT, 18/01/2022, 1.00e, 2.00e", eddie.deposit(one, date));
    }

    @Test
    void makeAWithdraw() throws ParseException {
        Date date = convertToDate("20/01/2022");
        Amount sixty_five = Amount.of(65);
        BankAccount bart = new BankAccount();
        bart.deposit(sixty_five, date);

        Amount thirty_three = Amount.negative(33);

        assertEquals("WITHDRAWAL, 20/01/2022, 33.00e, 32.00e", bart.withdraw(thirty_three, date));
    }

    @Test
    void makeMultipleWithdraw() throws ParseException {
        Date date = convertToDate("21/01/2022");
        Amount sixty_five = Amount.of(65);
        BankAccount joe = new BankAccount();
        joe.deposit(sixty_five, date);

        Amount nThirty_three = Amount.negative(33);
        assertEquals("WITHDRAWAL, 21/01/2022, 33.00e, 32.00e", joe.withdraw(nThirty_three, date));

        Amount nTwelve = Amount.negative(12);
        assertEquals("WITHDRAWAL, 21/01/2022, 20.00e, 12.00e", joe.withdraw(nTwelve, date));
    }

    private Date convertToDate(String stringDate) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
    }
//
//    @Test
//    void showHistory() {
//        BankAccount doe = new BankAccount();
//        doe.deposit(23);
//        assertEquals(List.of("DEPOSIT, 21/01/2022, 23e, 23e"), doe.history());
//    }
//
//    @Test
//    void showSeveralOperationHistory() {
//        BankAccount doe = new BankAccount();
//        doe.deposit(23);
//        doe.withdraw(10);
//        doe.withdraw(10);
//        doe.withdraw(10);
//        assertEquals(Arrays.asList(
//                "DEPOSIT, 21/01/2022, 23e, 23e",
//                "WITHDRAW, 21/01/2022, 10e, 13e",
//                "WITHDRAW, 21/01/2022, 10e, 3e",
//                "WITHDRAW, 21/01/2022, 10e, -7e"
//        ), doe.history());
//    }

}
