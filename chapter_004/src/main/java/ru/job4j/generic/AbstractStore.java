package ru.job4j.generic;

/**
 * abstract class AbstractStore implements Store.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * Контейнер для хранения объектов.
     */
    private SimpleArray<T> simpleArray;

    /**
     * Конструктор класса AbstractStore с одним параметром.
     * @param simpleArray Контейнер для хранения объектов.
     */
    public AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    /**
     * Метод add.
     * @param model добовляемый объект.
     */
    @Override
    public void add(T model) {
        this.simpleArray.add(model);
    }

    /**
     * Метод replace.
     * @param id которое нужно заменить.
     * @param model объект.
     * @return true если замена произошла, false если нет.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                simpleArray.set(i, model);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод delete.
     * @param id которое нужно удалить.
     * @return true если удален, false если нет.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (simpleArray.get(i).getId().equals(id)) {
                simpleArray.delete(i);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод findById.
     * @param id которое нужно найти.
     * @return неайденый объект, или null.
     */
    public T findById(String id) {
        T result = null;
        for (T element : simpleArray) {
            if (element.getId().equals(id)) {
                result = element;

            }
        }
        return result;
    }
}
