package com.smdev.algorithm.general.strings;

import java.util.*;

public class T02_PermutationDetector {

    public static final String EMPTY = "";

    /**
     * O(N)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isPermutation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true; // empty string can be considered a permutation of itself
        }

        char ch;
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            ch = s1.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1); // increase

            ch = s2.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) - 1); // decrease
        }

        Set<Integer> values = new HashSet<>(freq.values());
        return values.size() == 1 && values.contains(0);
    }


    /**
     * O(n log n) time,
     * O(n) space
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isPermutation1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        char ch1[] = s1.toCharArray();
        char ch2[] = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

    /**
     * O(N^2)
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isPermutation2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) { // O(N)
            s2 = s2.replaceFirst(String.valueOf(s1.charAt(i)), EMPTY); // O(N)
        }
        return s2.length() == 0;
    }

}
