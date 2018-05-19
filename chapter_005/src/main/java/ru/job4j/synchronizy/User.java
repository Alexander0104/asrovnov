package ru.job4j.synchronizy;

import java.util.Objects;

/**
 * class User.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class User implements Comparable<User> {


    private int id;
    private int amount;

    /**
     * Конструктор класс User.
     * @param id индекс в массиве.
     * @param amount сумма.
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Метод getId.
     * @return индекс.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Метод getAmount.
     * @return сумму.
     */
    public int getAmount() {
        return this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return this.id == user.id && this.amount == user.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.amount);
    }

    /**
     * Переопределенный метод compareTo.
     */
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.getId(), o.getId());
    }

}
