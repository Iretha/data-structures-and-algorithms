package com.smdev.classics;

import java.util.Arrays;

/**
 * Anagram -> the second word is received by reordering letters of the first word
 */
public class C08_Anagrams {

    /**
     * Simple Solution
     *
     * @param word
     * @param anagram
     * @return
     */
    private static boolean isAnagram1(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }

        char[] anagramChars = anagram.toCharArray();
        for (char ch : anagramChars) {
            if (word.indexOf(ch) == -1) {
                return false;
            }
            word = word.replaceFirst(String.valueOf(ch), "");
        }
        return true;
    }

    /**
     * More elegant solution
     *
     * @param word
     * @param anagram
     * @return
     */
    private static boolean isAnagram2(String word, String anagram) {
        if (word.length() != anagram.length()) {
            return false;
        }

        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);

        char[] anagramChars = anagram.toCharArray();
        Arrays.sort(anagramChars);

        return Arrays.equals(wordChars, anagramChars);
    }

    public static void main(String[] args) {
        System.out.println("======== Simple Solution ======");
        System.out.println(isAnagram1("arc", "car")); // true
        System.out.println(isAnagram1("arcc", "carc")); // true
        System.out.println(isAnagram1("arc", "ar")); // false
        System.out.println(isAnagram1("cat", "dog")); // false

        System.out.println("======== More Elegant Solution ======");
        System.out.println(isAnagram2("arc", "car")); // true
        System.out.println(isAnagram2("arcc", "carc")); // true
        System.out.println(isAnagram2("arc", "ar")); // false
        System.out.println(isAnagram2("cat", "dog")); // false
    }
}
