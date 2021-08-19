class Mathematics {

    private static int result;

    public static int calculation(int firstNumber, String operator, int secondNumber) {
            switch (operator) {
                case "+" -> result = firstNumber + secondNumber;
                case "-" -> result = firstNumber - secondNumber;
                case "*" -> result = firstNumber * secondNumber;
                case "/" -> result = firstNumber / secondNumber;
            }


        return result;
    }

}
