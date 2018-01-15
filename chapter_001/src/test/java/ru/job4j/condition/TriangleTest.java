package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Alexander Rovnov
 * @version 1.1
 * @since 1.1
 */
public class TriangleTest {
    /**
     * Test period.
     */
    @Test
    public void whenPeriodSetThreePointsThenTrianglePeriod() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);
        Point c = new Point(1, 0);
        // Вычисления расстояние между двумя точками в системе координат
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем полупериметр по длинам сторон.
        double result = triangle.period(ab, ac, bc);
        // Задаем ожидаемый результат.
        double expected = 5.5D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));

    }

    /**
     * Test area.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // создаем три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);
        Point c = new Point(1, 0);
        // Создаем объект треугольник и передаем в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2.5D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.0));
    }
}
