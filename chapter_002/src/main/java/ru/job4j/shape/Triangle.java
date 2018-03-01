package ru.job4j.shape;

/**
 * class Triangle implements Shape.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Triangle implements Shape {

    /**
     * метод draw создает треугольник.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("  + +  ");
        pic.append(" +   + ");
        pic.append("+++++++");
        return pic.toString();
    }
}
