import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConversion {

    enum RomanDial {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanDial(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanDial romanDial) -> romanDial.value).reversed())
                    .collect(Collectors.toList());
        }
    }

    public static int romanToArabic(String input) {
        String romanDial = input.toUpperCase();
        int result = 0;

        List romanDials = RomanDial.getReverseSortedValues();

        int i = 0;

        while ((romanDial.length() > 0) && (i < romanDials.size())) {
            RomanDial symbol = (RomanDial) romanDials.get(i);
            if (romanDial.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanDial = romanDial.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanDial.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List romanDials = RomanDial.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanDials.size())) {
            RomanDial currentSymbol = (RomanDial) romanDials.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
