package com.smdev.algorithm.general.challenges;

import java.util.*;

public class T01_UniqueCharactersDetector {


    /**
     * Uses Map
     * <p>
     * Worst Case: O(N) - if all are unique
     *
     * @param s
     * @return
     */
    public static boolean areCharsUnique(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }

        char ch;
        int cnt;
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            cnt = freq.getOrDefault(ch, 0) + 1;
            if (cnt > 1) {
                return false;
            }
            freq.put(ch, cnt);
        }
        return true;
    }

    /**
     * Via Set 1
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
}
