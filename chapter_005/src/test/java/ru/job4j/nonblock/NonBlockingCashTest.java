package ru.job4j.nonblock;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Test class NonBlockingCashTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class NonBlockingCashTest {

    private Model model;
    private NonBlockingCash nbc;

    @Before
    public void beforeTest() {
        this.model = new Model("1", "Test");
        this.nbc = new NonBlockingCash();
    }

    /**
     * Test_01.
     * add.
     */
    @Test
    public void whenAddModelThenModelInCache() {
        nbc.add(1, model);
        assertThat(nbc.get(1), is(model));
    }

    /**
     * Test_02.
     * delete.
     */
    @Test
    public void whenDeleteModelThenGetNull() {
        nbc.add(1, model);
        nbc.delete(1);
        assertNull(nbc.get(1));
    }

    /**
     * Test_03.
     * update.
     */
    @Test
    public void whenUpdateModelThenGetUpdatedModel() {
        nbc.add(1, model);
        Model updateModel = new Model("2", "Test2");
        try {
            nbc.update(1, updateModel);
        } catch (OptimisticException e) {
            e.printStackTrace();
        }
        assertThat(nbc.get(1), is(updateModel));
        assertThat(nbc.get(1).getVersion(), is(1));
    }
}