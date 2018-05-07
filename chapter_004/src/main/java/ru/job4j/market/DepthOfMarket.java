package ru.job4j.market;

import java.util.*;

/**
 * class DepthOfMarket.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class DepthOfMarket {

    /**
     * Идентификатор ценной бумаги.
     */
    private final String identity;

    /**
     * Покупка ценной бумаги(action).
     */
    private static final String BID = "bid";

    /**
     * Продажа ценной бумаги(action).
     */
    private static final String ASK = "ask";

    private final HashMap<String, LinkedList<Item>> container = new HashMap<>();
    private final LinkedList<Item> listBid = new LinkedList<>();
    private final LinkedList<Item> listAsk = new LinkedList<>();

    DepthOfMarket(String identity) {
        this.identity = identity;
    }

    /**
     * Метод добавления в коллекцию.
     * @param item заявка.
     */
    public void addItem(Item item) {
        if (item.getAction().equals(ASK)
                && item.getBook().equals(this.identity)) {
            this.listAsk .add(item);
            this.deleteItem(this.listAsk, ASK);
            Collections.sort(this.listAsk);
            this.container.put(ASK, this.listAsk);
        } else if (item.getAction().equals(BID)
                && item.getBook().equals(this.identity)) {
            this.listBid .add(item);
            this.deleteItem(this.listBid, BID);
            Collections.sort(this.listBid);
            this.container.put(BID, this.listBid);
        }
        check(this.listAsk, this.listBid);
    }

    /**
     * Метод check.
     * @param listA заявки на продажу ценных бумаг.
     * @param listB заявки на покупку ценных бумаг.
     */
    private void check(LinkedList<Item> listA, LinkedList<Item> listB) {
        int size = listA.size() >= listB.size() ? listB.size() : listA.size();
        for (int i = 0; i != size; i++) {
            if (listB.get(i).getPrice() == listA.get(i).getPrice()
                    && listB.get(i).getVolume() == listA.get(i).getVolume()) {
                listA.remove(i);
                listB.remove(i);
            }
        }
    }

    /**
     * Метод deleteItem.
     * @param list список заявок.
     * @param action покупка или продажа ценной бумаги.
     */
    private void deleteItem(LinkedList<Item> list, String action) {
        for (Item l : list) {
            if (l.getType().equals(Item.Type.DELETE)
                    && l.getAction().equals(action)) {
                list.remove(l);
            }
        }
    }

    /**
     * Метод getContainer.
     * @return container.
     */
    public HashMap<String, LinkedList<Item>> getContainer() {
        return this.container;
    }
}
