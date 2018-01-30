package ru.job4j.array;

/**
 * Class FindLoop.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class FindLoop {

    /**
     * Method indexOf.
     * @param date array.
     * @param el the search item in the array
     * @return -1 if element not search, or search item.
     */
    public int indexOf(int[] date, int el)  {
        int rst = -1;

        for (int index = 0; index != date.length; index++) {
            if (date[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
