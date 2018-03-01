package ru.job4j.shape;

/**
 * class Paint.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Paint {

    /**
     * метод draw используется для прорисовки сформированной строки.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
