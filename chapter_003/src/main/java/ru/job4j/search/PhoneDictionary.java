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
        for (Person person : persons) {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)) {
                result.add(person);
            }

        }
        return result;
    }
}
