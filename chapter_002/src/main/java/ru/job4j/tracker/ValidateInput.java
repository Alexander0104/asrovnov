package ru.job4j.tracker;


// Пример с наследованием
///**
// * class ValidateInput наследуемый от ConsoleInput.
// * @author Alexander Rovnov.
// * @version 1.0
// * @since 1.0
// */
//public class ValidateInput extends ConsoleInput {
//
//    public int ask(String question, int[] range) {
//        boolean invalid = true;
//        int value = -1;
//        do {
//            try {
//                value = super.ask(question, range);
//                invalid = false;
//            } catch (MenuOutException moe) {
//                System.out.println("Ошибка ввода: Введите пункт из меню");
//            } catch (NumberFormatException nfe) {
//                System.out.println("Ошибка ввода: Введите корректные данные");
//            }
//        } while (invalid);
//        return value;
//    }
//}

// Пример с декораторатором.
// Избавляемся от наследования за счет композиции.
/**
 * class ValidateInput implements Input.
 * @author Alexander Rovnov.
 * @version 1.1.
 * @since 1.1.
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Ошибка ввода: Введите пункт из меню");
            } catch (NumberFormatException nfe) {
                System.out.println("Ошибка ввода: Введите корректные данные");
            }
        } while (invalid);
        return value;
    }
}
