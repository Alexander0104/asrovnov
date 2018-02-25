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
}
