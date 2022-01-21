import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BankAccountTest {

    @Test
    void makeADeposit() {
        assertEquals(1, new BankAccount().deposit(1));
    }

    @Test
    void makeADoubleDeposit() {
        BankAccount clientOne = new BankAccount();
        assertEquals(1, clientOne.deposit(1));
        assertEquals(2, clientOne.deposit(1));
    }

    @Test
    void makeAWithdraw() {
        BankAccount bart = new BankAccount();
        bart.deposit(65);
        assertEquals(32, bart.withdraw(33));
    }

    @Test
    void makeMultipleWithdraw() {
        BankAccount bart = new BankAccount();
        bart.deposit(65);
        assertEquals(32, bart.withdraw(33));
        assertEquals(20, bart.withdraw(12));
    }

    @Test
    void showHistory() {
        BankAccount doe = new BankAccount();
        doe.deposit(23);
        assertEquals(List.of("DEPOSIT, 21/01/2022, 23e, 23e"), doe.history());
    }

    @Test
    void showSeveralOperationHistory() {
        BankAccount doe = new BankAccount();
        doe.deposit(23);
        doe.withdraw(10);
        doe.withdraw(10);
        doe.withdraw(10);
        assertEquals(Arrays.asList(
                "DEPOSIT, 21/01/2022, 23e, 23e",
                "WITHDRAW, 21/01/2022, 10e, 13e",
                "WITHDRAW, 21/01/2022, 10e, 3e",
                "WITHDRAW, 21/01/2022, 10e, -7e"
        ), doe.history());
    }

}
