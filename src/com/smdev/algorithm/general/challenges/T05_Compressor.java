package com.smdev.algorithm.general.challenges;

public class T05_Compressor {

    /**
     * Challenge: Give a string with repeating characters (i.e. "aaabb") write
     * an algorithm that will compress the string down to the character, followed
     * by the number of times it appears in the string (i.e "a3b2").
     * If the compressed string is not smaller than original, return original.
     */
    public static String compress(String str) {
        if (str == null || str.length() < 3) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();

        int position = 1;
        char prevCh = str.charAt(0);
        char currCh = str.charAt(1);
        int counter = 1;
        while (position < str.length()) {
            currCh = str.charAt(position++);

            if (currCh == prevCh) {
                counter++;
            } else {
                compressed.append(prevCh);
                if (counter > 1) {
                    compressed.append(counter);
                    counter = 1;
                }

                prevCh = currCh;
            }
        }

        // append the last char
        compressed.append(currCh);
        if (counter > 1) {
            compressed.append(counter);
        }

        return str.length() == compressed.length() ? str : compressed.toString();
    }
}
