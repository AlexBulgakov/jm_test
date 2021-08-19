import java.util.Scanner;

public class CorrectData {

    int firstNumber;
    int secondNumber;

    int firstToArabicNumber;
    int secondToArabicNumber;

    String operator;
    String[] inputLine;

    public CorrectData() throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        if (line.equals("exit")) System.exit(0);
        inputLine = line.split(" ");

        if (isOperator(inputLine[1])) {
            operator = inputLine[1];
        }



        if (isDigit(inputLine)) {
            if (inRange(firstNumber) && inRange(secondNumber)) {
                System.out.println(arabicCalc(inputLine));
            }
        } else {
            System.out.println(romanCalc(inputLine));
        }
    }

    public boolean isDigit(String[] line) {

        try{
            firstNumber = Integer.parseInt(line[0]);
            secondNumber = Integer.parseInt(line[2]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int arabicCalc(String[] line) {
        int result;
        firstNumber = Integer.parseInt(line[0]);
        secondNumber = Integer.parseInt(line[2]);

        return result = Mathematics.calculation(firstNumber, operator, secondNumber);
    }

    public String romanCalc(String line[]) throws Exception {
        String result = null;
        String firstNumber = line[0];
        String secondNumber = line[2];
        firstToArabicNumber = TypeConversion.romanToArabic(firstNumber);
        secondToArabicNumber = TypeConversion.romanToArabic(secondNumber);

        if (inRange(firstToArabicNumber) && inRange(secondToArabicNumber)) result = TypeConversion.arabicToRoman(Mathematics.calculation(firstToArabicNumber, operator, secondToArabicNumber));

        return result;
    }

    public boolean inRange(int number) throws Exception {
        if (number < 1 || number > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно!");
        }
        return true;
    }

    public boolean isOperator(String operator) throws Exception {
        if (!(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/"))) {
            throw new Exception("Введен недопустимый оператор!");
        }
        return true;

    }

}
