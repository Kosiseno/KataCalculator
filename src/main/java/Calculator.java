import java.io.IOException;

//Калькулятор на switch'e

public class Calculator {

    public static int calculate(int firstNumber, int secondNumber, String operationType) throws IOException {
        int result = 0;
        switch (operationType) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;
            default:
                throw new IOException("Некорректный тип операции");
        }
        if (InputStringHandler.romanNum && result < 1) {
            throw new ArithmeticException();
        }

        return result;
    }

}
