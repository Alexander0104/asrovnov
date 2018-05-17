package ru.job4j.jmm;

/**
 * class ProblemMultithreading.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class ProblemMultithreading {
    private static int count = 0;
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                count++;
                System.out.println(String.format("Поток №1, count = %d", count));
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                count++;
                System.out.println(String.format("Поток №2, count = %d", count));
            }
        }.start();
    }
}
