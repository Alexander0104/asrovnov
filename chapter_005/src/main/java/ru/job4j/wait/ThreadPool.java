package ru.job4j.wait;

import java.util.LinkedList;
import java.util.Queue;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * class ThreadPool.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
@ThreadSafe
public class ThreadPool {

    private final int processors;
    private volatile boolean running = true;
    @GuardedBy("this")
    private final Queue<Runnable> queue = new LinkedList<>();

    public ThreadPool() {
        this.processors = Runtime.getRuntime().availableProcessors();
    }

    /**
     * Метод add.
     * Метод добавляет задачи в очередь.
     * @param work задача.
     */
    public synchronized void add(Work work) {
        if (this.running) {
            this.queue.offer(work);
        }
    }

    /**
     * Метод execute.
     * Метод достает задачи из очереди.
     */
    public void execute() {
        for (int i = 0; i < this.processors; i++) {
            new MyThread().run();
        }
    }

    /**
     * Метод stop.
     * Метод останавливает пул.
     */
    public void stop() {
        this.running = false;
    }

    /**
     * class MyThread extends Thread.
     */
    private class MyThread extends Thread {
        @Override
        public void run() {
            while (!queue.isEmpty()) {
                Runnable task = queue.poll();
                if (task != null) {
                    task.run();
                }
            }
        }
    }
}
