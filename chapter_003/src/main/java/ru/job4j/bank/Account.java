package ru.job4j.bank;

/**
 * class Account.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Account {

    /**
     * Поля инициализируют Account.
     */
    private double value;
    private String requisites;

    /**
     * Конструктор класса Account с 2-мя параметрами.
     * @param value сумма.
     * @param requisites реквезиты.
     */
    public Account(double value, final String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Метод getValue.
     * @return сумма.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Метод getRequisites.
     * @return реквезиты.
     */
    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Метод transfer.
     * @param destination пункт
     * @param amount колличество
     * @return true или false.
     */
    public boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.value && destination != null) {
            success = true;
            this.value -= amount;
            destination.value += amount;
        }
        return success;
    }
}
