package ru.job4j.wait;

import org.junit.Test;

/**
 * Test class ThreadPool.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class ThreadPoolTest {

    /**
     * Test.
     */
    @Test
    public void whenAddSixWorks() {
        ThreadPool pool = new ThreadPool();
        Thread add = new Thread(new Runnable() {
            @Override
            public void run() {
                pool.add(new Work("1"));
                pool.add(new Work("2"));
                pool.add(new Work("3"));
                pool.add(new Work("4"));
                pool.add(new Work("5"));
                pool.add(new Work("6"));
            }
        });
        Thread exec = new Thread(new Runnable() {
            @Override
            public void run() {
                pool.execute();
            }
        });
        add.start();
        try {
            add.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.start();
        try {
            exec.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.stop();
    }
}