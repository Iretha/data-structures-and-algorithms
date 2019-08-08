package com.smdev.algorithm.general.challenges;

public class T04_OneAway {


    /**
     * Challenge: There are three types of edits that can be performed on strings: insert a character,
     * remove a character, or replace a character. Given two strings, write a function to check if they are
     * one or zero edits away.
     */
    public static boolean oneAway(String str1, String str2) {
        if (str1 == null || str2 == null || Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        if (str1.equals(str2)) {
            return true;
        }

        int len1 = str1.length();
        int len2 = str2.length();
        int edits = 0;
        if (len2 == len1 + 1) { // char inserted
            for (int i = 0; i < len1; i++) {
                if (str2.charAt(i + edits) != str1.charAt(i)) { // because it's an insert
                    edits++;
                }

                if (edits > 1) {
                    break;
                }
            }
        } else if (len2 == len1) { // char replaced
            for (int i = 0; i < len1; i++) {
                if (str2.charAt(i) != str1.charAt(i)) { // because it's a replace
                    edits++;
                }

                if (edits > 1) {
                    break;
                }
            }
        } else if (len2 == len1 - 1) { // char deleted
            for (int i = 0; i < len1; i++) {
                if (i == len2) {
                    break; // we reached the end
                }

                if (str1.charAt(i) != str2.charAt(i - edits)) { // because it's a delete
                    edits++;
                }

                if (edits > 1) {
                    break;
                }
            }
        }
        return edits < 2;
    }
}
