import java.util.LinkedHashMap;
import java.util.Map;

public class Converter {
    static Integer[] arabic = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Массив арабский чисел
    static String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"}; // Массив римских чисел

    //конвертируем римское число в арабское
    public static int convertRomanToArabicNumber(String stringWithNumber) {
        int result = -1;
        for (int i = 1; i <= roman.length; i++) {
            if (roman[i - 1].equalsIgnoreCase(stringWithNumber)) {
                result = arabic[i - 1];
            }
        }
        return result;
    }

    public static String RomanNumerals(int resultArabicNumber) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>(); //используем линкедхешмап так как удобно иметь доступ по паре ключ - значение
        roman_numerals.put("C", 100); // Максимальное значение (ограничено заданием)
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);// 90,40,9,4 обязательно нужны, так как имеют специфическую форму записи!
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String resultRomanNumber = "";
        for (Map.Entry<String, Integer> entry : roman_numerals.entrySet()) { //цикл по парам ключ - значение
            int quantity = resultArabicNumber / entry.getValue(); //берём результат вычисление через арабские числа и делим его на максимальное значение римских цифр.
            resultRomanNumber += saverRomanNumber(entry.getKey(), quantity); // т.к. int, если получаем 0, то ничего не добавляется.
            resultArabicNumber = resultArabicNumber % entry.getValue(); //получаем остаток от деления и переходим к следующей итерации .
        }
        return resultRomanNumber;
    }

    public static String saverRomanNumber(String savesNumber, int quantity) {
        if (savesNumber == null) {
            return null;
        } else {
            StringBuilder temporaryString = new StringBuilder();// используем StringBuilder, т.к. он изменяемый.
            for (int i = 0; i < quantity; i++) {
                temporaryString.append(savesNumber); //добовляем нужное число необходмое количество раз.
            }
            return temporaryString.toString();
        }
    }
}
