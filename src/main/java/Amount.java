import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Amount {

    private final Locale locale = new Locale("en", "UK");

    private final DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);

    private final double value;

    public Amount(double value) {
        this.value = value;
    }

    public static Amount of(double value){
        return new Amount(value);
    }

    public static Amount negative(double value) {
        return new Amount(-value);
    }

    public Amount add(Amount amount) {
        return new Amount(value + amount.value);
    }

    public Amount subtract(Amount amount) {
        return new Amount(value - amount.value);
    }

    public String decimalFormat() {
        String pattern = "#.00";
        decimalFormat.applyPattern(pattern);
        return decimalFormat.format(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Amount amount)) return false;
        return Double.compare(amount.value, value) == 0 && Objects.equals(locale, amount.locale) && Objects.equals(decimalFormat, amount.decimalFormat);
    }
}
