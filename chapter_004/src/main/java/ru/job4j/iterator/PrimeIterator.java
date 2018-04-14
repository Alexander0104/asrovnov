package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {

    /**
     * Массив для хранения элементов.
     */
    private int[] array;

    /**
     * Индекс.
     */
    private int index;

    /**
     * Конструктор класса EvenIterator с одним параметром.
     * @param array массив.
     */
    public PrimeIterator(int[] array) {
        this.array = array;
    }

    /**
     * Метод hasNext.
     * @return true если элемент простое числол и false если элемент четный.
     */
    @Override
    public boolean hasNext() {
        boolean even = false;
        while (this.index != this.array.length) {
            if (checkPrime(array[index])) {
                even = true;
                break;
            }
            index++;
        }
        return even;
    }

    /**
     * Метод next.
     * @return возвращает следующий элемент в итерации.
     */
    @Override
    public Integer next() {
        hasNext();
        if (this.index >= this.array.length) {
            throw new NoSuchElementException();
        }
        return this.array[this.index++];
    }

    /**
     * Метод checkPrime.
     * @return true если если элемент простое числол и false если элемент четный.
     */
    public boolean checkPrime(int number) {
        boolean result = false;
        for (int i = 2; i <= number; i++) {
            if (i > Math.sqrt(number)) {
                result = true;
                break;
            }
            if (number % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
