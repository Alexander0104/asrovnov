package ru.job4j.search;

import java.util.List;
import java.util.ArrayList;

/**
 * class ConvertList.
 * Convert two dimensional array to ArrayList and vice versa.
 * @author Alexander Rovnov.
 * @version 1.2
 * @since 1.2
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
        int cells = (int) Math.ceil((double) list.size() / rows);
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer value : list) {
            array[row][cell++] = value;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }

    /**
     * метод convert.
     * метод проходитт по вем элемента всех массивов в списке
     * list и добавляет их в один общий list<Integer>
     * @param list список с массивами.
     * @return новый список.
     */
    public List<Integer> convert(List<int[][]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[][] i : list) {
            for (int[] j : i) {
                for (int l : j) {
                    result.add(l);
                }
            }
        }
        return result;
     }
}
