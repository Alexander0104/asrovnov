package ru.job4j.nonblock;

/**
 * class Model.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class Model {

    private String name;
    private String value;
    private int version;

    public Model(String name, String value) {
        this.name = name;
        this.value = value;
        this.version = 0;
    }

    public void change(String name) {
        this.name = name;
        version++;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public int getVersion() {
        return version;
    }
}

