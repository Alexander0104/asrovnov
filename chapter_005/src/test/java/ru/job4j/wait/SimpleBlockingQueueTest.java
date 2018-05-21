package ru.job4j.wait;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class SimpleBlockingQueue.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class SimpleBlockingQueueTest {

    private SimpleBlockingQueue<String> queue;

    @Before
    public void beforeTest() {
        queue = new SimpleBlockingQueue<>();
    }

    /**
     * Test.
     * Если очередь заполнена полностью, то при попытке добавления
     * поток producer блокируется, до тех пор пока consumer не извлечет
     * очередные данные. И наоборот если очередь пуста поток consumer блокируется,
     * до тех пор пока producer не поместит в очередь данные.
     */
    @Test
    public void whenAddOfferThreeElementsThenPollThreeElements() {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.offer("Value №1");
                queue.offer("Value №2");
                queue.offer("Value №3");
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                assertThat(queue.poll(), is("Value №1"));
                assertThat(queue.poll(), is("Value №2"));
                assertThat(queue.poll(), is("Value №3"));
            }
        });
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}