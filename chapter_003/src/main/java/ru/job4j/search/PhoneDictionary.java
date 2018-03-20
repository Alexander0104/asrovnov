package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * class PhoneDictionary.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    /**
     * метод add.
     * долбавляет человека в список.
     * @param person человек.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод find
     * @param key ключ поиска.
     * @return список подощедщих пользователей по ключу.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (int index = 0; index != this.persons.size(); index++) {
            if (this.persons.get(index).getName().contains(key)
                    || this.persons.get(index).getSurname().contains(key)
                    || this.persons.get(index).getPhone().contains(key)
                    || this.persons.get(index).getAddress().contains(key)) {
                result.add(persons.get(index));
            }
        }
        return result;
    }
}
