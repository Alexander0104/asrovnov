package ru.job4j.wait;

import java.util.LinkedList;
import java.util.Queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * class SimpleBlockingQueue.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();
    private boolean valueSet = false;

    /**
     * Метод offer.
     * @param value значение.
     */
    public synchronized void offer(T value) {
        while (this.valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.add(value);
        this.valueSet = true;
        System.out.println("Отправлен - " + value);
        notify();
    }

    /**
     * Метод poll.
     * @return value.
     */
    public synchronized T poll() {
        while (!this.valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.valueSet = false;
        notify();
        return this.queue.poll();
    }
}
