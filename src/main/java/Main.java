public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Добро пожаловать в калькулятор для работы с целыми числами!");
        System.out.println("Тут ты можешь выполнить операции:");
        System.out.println("Сложения(+)");
        System.out.println("Вычитания(-)");
        System.out.println("Умножения(*)");
        System.out.println("Деления(\\)");
        System.out.println("Ты можешь использовать арабские и римские цифры, одноко не смешивай их!");
        System.out.println("Перед и после знаком операции ставь пробел!");


        InputStringHandler.takeProcessString();
    }
}
