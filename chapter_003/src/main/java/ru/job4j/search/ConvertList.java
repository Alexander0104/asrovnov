package ru.job4j.search;

import java.util.List;
import java.util.ArrayList;

/**
 * class ConvertList.
 * Convert two dimensional array to ArrayList and vice versa.
 * @author Alexander Rovnov.
 * @version 1.1
 * @since 1.1
 */
public class ConvertList {

    /**
     * метод toList.
     * долбавляет элементы массива в List<Integer>.
     * @param array двумерный массив целых чисел.
     * @return новый список.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    /**
     * метод toArray.
     * равномерно разбивает List<Integer> на количество строк двумерного массива.
     * @param list список.
     * @param rows колличесво строк двумерного массива.
     * @return новый массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int column = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] result = new int[rows][column];
        int x = 0, y = 0, count = 0;
        for (int[] out : result) {
            for (int in : out) {
                if (count < list.size()) {
                    result[x][y++] = list.get(count++);
                }
            }
            x++;
            y = 0;
        }
        return result;
    }

    /**
     * метод convert.
     * метод проходитт по вем элемента всех массивов в списке
     * list и добавляет их в один общий list<Integer>
     * @param list список с массивами.
     * @return новый список.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] i : list) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;
     }
}
