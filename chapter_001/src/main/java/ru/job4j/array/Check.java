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
        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();
        int count = 0;

        for (int indexOut = 0; indexOut != originArray.length; indexOut++){
            for (int indexIn = 0; indexIn != subArray.length; indexIn++) {
                if (originArray[indexOut] == subArray[count]) {
                    count++;
                    if (count == subArray.length) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
