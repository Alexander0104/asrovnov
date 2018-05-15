package ru.job4j.coffee;

import java.util.ArrayList;

/**
 * class CoffeeMachine.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class CoffeeMachine {

    /**
     * Метод changes.
     * @param value купюра.
     * @param price цена.
     * @return массив со сдачей.
     */
    public int[] changes(int value, int price) {
        int[] coins = {1, 2, 5, 10};
        ArrayList<Integer> list = new ArrayList<>();
        int remain = value - price;
        int index = coins.length - 1;
        while (remain > 0) {
            while (remain >= coins[index]) {
                list.add(coins[index]);
                remain -= coins[index];
            }
            index--;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
