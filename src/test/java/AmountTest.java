import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AmountTest {

    @Test
    void initAmount() {
        assertEquals(Amount.of(0), new Amount(0));
    }

    @Test
    void negativeAmount() {
        assertEquals(Amount.of(-100), Amount.negative(100));
    }

    @Test
    void addAmount() {
        Amount one = Amount.of(1);
        Amount anotherOne = Amount.of(1);
        Amount two = Amount.of(2);
        assertEquals(two, one.add(anotherOne));
    }

    @Test
    void subtractAmount() {
        Amount three = Amount.of(3);
        Amount two = Amount.of(2);
        Amount one = Amount.of(1);
        assertEquals(one, three.subtract(two));
    }

    @Test
    void decimalFormat() {
        Amount ten = Amount.of(10);
        assertEquals("10.00", ten.decimalFormat());
    }
}
