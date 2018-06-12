package ru.job4j.tracker;

import java.util.Scanner;

/**
 * class ConsoleInput.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод ask.
     * @param question вопрос
     * @return возвращает строку который ввел пользователь.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Ошибка ввода: Выход из диапазона меню");
        }
    }
}
