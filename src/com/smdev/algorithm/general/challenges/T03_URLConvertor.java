package com.smdev.algorithm.general.challenges;

import java.util.Arrays;

public class T03_URLConvertor {

    /**
     * Uses Map
     * <p>
     * Worst Case: O(N) - if all are unique
     */
    public static String urlify(String str, int maxLength) {
        if (str == null) {
            return str;
        }

        str = str.strip();

        char ch;
        int currLength = 0;
        char[] urlChars = new char[maxLength];
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);

            if (Character.isWhitespace(ch)) { // handles ' ' /n /t /r etc.
                if (currLength >= maxLength - 3) {
                    break; // if some of the last 3 characters is a whitespace => stop here
                }
                urlChars[currLength++] = '%';
                urlChars[currLength++] = '2';
                urlChars[currLength++] = '0';
            } else {
                urlChars[currLength++] = ch;
            }

            if (currLength == maxLength) {
                break;
            }
        }
        return String.valueOf(currLength < maxLength ? Arrays.copyOfRange(urlChars, 0, currLength) : urlChars);
    }
}
