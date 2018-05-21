package ru.job4j.wait;

/**
 * class Work implements Runnable.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class Work implements Runnable {

    private String count;

    public Work(String count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s Старт: %s", Thread.currentThread().getName(), this.count));
        process();
        System.out.println(String.format("%s Стоп", Thread.currentThread().getName()));
    }

    private void process() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
