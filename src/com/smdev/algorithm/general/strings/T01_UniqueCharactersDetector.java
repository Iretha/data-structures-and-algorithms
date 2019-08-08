package com.smdev.algorithm.general.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T01_UniqueCharactersDetector {

    public static boolean areCharsUnique(String s) {
        return areCharsUnique1(s);
    }

    /**
     * O(N)
     */
    public static boolean areCharsUnique1(String s) {
        if (s == null) {
            return false;
        }
        Set<Character> chs = new HashSet<>();
        for (int idx = 0; idx < s.length(); idx++) {
            if (!chs.add(s.charAt(idx))) {
                return false;
            }
        }
        return true;
    }

    /**
     * O(N)
     *
     * @param s
     * @return
     */
    public static boolean areCharsUnique2(String s) {
        if (s == null) {
            return false;
        }
        Set<Character> chs = new HashSet(Arrays.asList(s.length()));
        return s.length() == chs.size();
    }
}
