package ru.job4j.wait;

/**
 * class MyLock.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class MyLock {

    private boolean flag = false;

    public synchronized void lock() {
        while (this.flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.flag = true;
    }

    public synchronized void unLock() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.flag = false;
        notifyAll();
    }
}


