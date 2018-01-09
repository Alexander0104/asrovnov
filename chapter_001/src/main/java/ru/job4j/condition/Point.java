package ru.job4j.condition;

/**
 * Class Point.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Point {
    private int x;
    private int y;

    // конструктор class Point
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // метод для вычисления расстояние между двумя точками в системе координат
    public double distanceTo(Point that) {
        Point a = this;
        Point b = that;

        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;

        double result = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(5, 10);
        Point b = new Point(4, 8);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        // вызов метода distanceTo(Point that)
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
