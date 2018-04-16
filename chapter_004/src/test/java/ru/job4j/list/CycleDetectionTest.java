package ru.job4j.list;
import ru.job4j.list.CycleDetection.Node;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class CycleDetectionTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class CycleDetectionTest {

    private static CycleDetection<Integer> cycleDetection;
    private static Node<Integer> first;
    private static Node<Integer> two;
    private static Node<Integer> third;
    private static Node<Integer> four;

    @Before
    public void beforeTest() {
        cycleDetection = new CycleDetection<>();
        first = new Node<>(1);
        two = new Node<>(2);
        third = new Node<>(3);
        four = new Node<>(4);
    }

    /**
     * Test_01.
     */
    @Test
    public void whenCreateCycleListThanTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        boolean hasCycle = cycleDetection.hasCycle(first);
        assertThat(hasCycle, is(true));
    }

    /**
     * Test_02.
     */
    @Test
    public void whenCreateCycleListAndCycleItemIsNotFirstThanTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = two;
        boolean hasCycle = cycleDetection.hasCycle(first);
        assertThat(hasCycle, is(true));
    }

    /**
     * Test_03.
     */
    @Test
    public void whenCreateListWithoutCycleThanFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        boolean hasCycle = cycleDetection.hasCycle(first);
        assertThat(hasCycle, is(false));
    }
}