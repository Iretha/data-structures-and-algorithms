package com.smdev.classics;

import java.util.HashMap;
import java.util.Map;

public class C03_RansomNote {

    private static boolean canWrite(String note, String text) {
        Map<String, Integer> freqNote = map(note.replaceAll("\\s+", ""));
        Map<String, Integer> freqText = map(text.replaceAll("\\s+", ""));
        for (Map.Entry<String, Integer> e : freqNote.entrySet()) {
            if (freqText.getOrDefault(e.getKey(), 0) < e.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static Map<String, Integer> map(String str) {
        Map<String, Integer> freq = new HashMap<>();
        String letter;
        for (int i = 0; i < str.length(); i++) {
            letter = String.valueOf(str.charAt(i));
            freq.put(letter, freq.getOrDefault(letter, 0) + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        System.out.println(canWrite("Pay", "ayP"));
        System.out.println(canWrite("Pay", "ayp"));
        System.out.println(canWrite("Pay1000000$", "000 $ 0 ay0P 10"));
    }
}
