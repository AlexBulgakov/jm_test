public class Calculator {

    public void run() throws Exception {
        System.out.println("Добро пожаловать в консольный калькулятор. Он умеет складывать, вычитать, умножать и делить целые числа, а так же работать с Римскими числами!");
        System.out.println("Для выхода из программы введите 'exit'!");
        System.out.println();
        while(true) {
            System.out.println("Введите выражение в одной строке через пробел: ");

            new CorrectData();
        }

    }
}
