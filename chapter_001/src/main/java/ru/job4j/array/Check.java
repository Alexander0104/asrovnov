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
        int count = 0;
        for (int out = 0; out != or.length; out++) {
            if (or[out] == su[count]) {
                count++;
            } else {
                count = 0;
            }
            for (int in = 0; in != su.length; in++) {
                if (count == su.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
