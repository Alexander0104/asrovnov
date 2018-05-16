package ru.job4j.threads.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * RectangleMove implements Runnable.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class RectangleMove implements Runnable {

    private final Rectangle rect;
    private static final double CHANGE_DIRECTION = -1;
    private double moveX = 1D;
    private double moveY = 0.5D;

    /**
     * Конструктор класса RectangleMove.
     * Инициализирует квадрат.
     * @param rect квадрат.
     */
    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    /**
     * Метод run.
     * Меняет кординаты квадрата каждые 40 миллисекунд.
     */
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            if (this.rect.getX() >= 300D || this.rect.getX() <= 0D) {
                this.moveX *= CHANGE_DIRECTION;
            }
            if (this.rect.getY() >= 300D || this.rect.getY() <= 0D) {
                this.moveY *= CHANGE_DIRECTION;
            }
            this.rect.setX(this.rect.getX()  + this.moveX);
            this.rect.setY(this.rect.getY() + this.moveY);
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
