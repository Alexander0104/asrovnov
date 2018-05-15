package ru.job4j.coffee;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test class CoffeeMachine.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class CoffeeMachineTest {

    /**
     * Test.
     * changes.
     */
    @Test
    public void whenAddChanges50And35ThenResult10And5() {
        CoffeeMachine coffee = new CoffeeMachine();
        int[] expected = {10, 5};
        assertThat(coffee.changes(50, 35), is(expected));
    }
}