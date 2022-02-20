import java.io.IOException;
import java.util.Scanner;

public class InputStringHandler {

    static boolean romanNum = false; // римское число?

    public static void takeProcessString() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пример");
        String[] values = scanner.nextLine().split(" "); //Парсим строку по пробелу

        //Проверяем длинну массива

        if (values.length < 3) {
            throw new Exception("Возможно вы не использовали пробелы между числами? Строка не является простой арифметической операцией");
        } else if (values.length > 3) {
            throw new Exception("формат введённой строки не удовлетворяет заданным условиям - два операнда и один оператор (+, -, /, *)");
        }

        String operationType = values[1]; // Тип операции (+,-,*,/)
        String firstNumber = values[0]; // Первое введённое число
        String secondNumber = values[2]; // Второе введённое число

        //Проверяем, являются ли числа арабскими.

        if ((firstNumber.chars().allMatch(Character::isDigit)) && (secondNumber.chars().allMatch(Character::isDigit))) {
            int localA = Integer.parseInt(firstNumber);
            int localB = Integer.parseInt(secondNumber);
            if (!((localA > 0 && localA <= 10) && (localB > 0 && localB <= 10))) {
                throw new IOException("Одно из чисел меньше нуля или больше 10!");
            }
            System.out.println("Результат: " + Calculator.calculate(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber), operationType));
        } else {
            romanNum = true;

            //Конвертируем из римских в арабские и проверяем диапозон.
            int localA = Converter.convertRomanToArabicNumber(firstNumber);
            int localB = Converter.convertRomanToArabicNumber(secondNumber);

            if (!((localA > 0 && localA <= 10) && (localB > 0 && localB <= 10))) {
                throw new IOException("Одно из чисел меньше нуля или больше 10!");
            }
            int result = Calculator.calculate(localA, localB, operationType); //вычисляем результат в арабских и передаём в метод RomanNumerals
            System.out.println("Результат: " + Converter.RomanNumerals(result));

        }
        System.out.println("Продолжить? Y/N");

        if (scanner.next().equalsIgnoreCase("Y")) {
            takeProcessString();
        } else {
            System.out.println("Пока!");
            System.exit(-1);
        }
    }

}
