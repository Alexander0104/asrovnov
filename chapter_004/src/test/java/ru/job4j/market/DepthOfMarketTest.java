package ru.job4j.market;

import java.util.*;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test class DepthOfMarketTest.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class DepthOfMarketTest {

    private DepthOfMarket dom;

    @Before
    public void beforeTest() {
        dom = new DepthOfMarket("Google");
        dom.addItem(new Item(1, "Google", Item.Type.ADD, "bid", 10, 15));
        dom.addItem(new Item(2, "Google", Item.Type.DELETE, "bid", 20, 25));
        dom.addItem(new Item(3, "Google", Item.Type.ADD, "bid", 30, 35));
        dom.addItem(new Item(4, "Google", Item.Type.ADD, "ask", 40, 45));
        dom.addItem(new Item(5, "Google", Item.Type.ADD, "ask", 10, 15));
        dom.addItem(new Item(6, "Google", Item.Type.ADD, "ask", 50, 55));
    }

    /**
     * Test_01.
     */
    @Test
    public void whenAddItem() {
        Iterator<Map.Entry<String, LinkedList<Item>>> it = dom.getContainer().entrySet().iterator();
        Set<String> key = dom.getContainer().keySet();
        assertThat(it.next().getValue().element().getPrice(), is(50));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue().element().getPrice(), is(30));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * Test_02.
     * Проверяем ключи.
     */
    @Test
    public void whenAddItemCheckKeyThenAskAndDid() {
        Iterator<Map.Entry<String, LinkedList<Item>>> it = dom.getContainer().entrySet().iterator();
        Set<String> key = dom.getContainer().keySet();
        assertThat(it.next().getKey(), is("ask"));
        assertThat(it.next().getKey(), is("bid"));
        assertThat(key.size(), is(2));
    }
}
