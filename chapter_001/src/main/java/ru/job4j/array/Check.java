package ru.job4j.array;

/**
 * class Check.
 * @author Alexander Rovnov.
 * @version 1.0
 * @since 1.0
 */
public class Check {

    /**
     * Method sort.
     * @param origin String.
     * @param sub String
     * @return return true if origin contains sub string, false if not contains.
     */
    public boolean contains(String origin, String sub) {
        char[] or = origin.toCharArray();
        char[] su = sub.toCharArray();
        for (int out = 0; out <= (or.length - su.length); out++) {
            for (int in = 0; in < or.length; in++) {
                if (or[out + in] != su[in]) {
                    break;
                }
                if (in == su.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
