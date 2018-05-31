package ru.job4j.nonblock;

/**
 * class OptimisticException extends RuntimeException.
 * @author Alexander Rovnov
 * @version 1.0
 * @since 1.0
 */
public class OptimisticException extends RuntimeException {

    public OptimisticException(String msg) {
        super(msg);
    }
}
