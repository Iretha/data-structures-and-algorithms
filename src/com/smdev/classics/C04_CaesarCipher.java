package com.smdev.classics;

public class C04_CaesarCipher {

    private static final String TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static String encrypt(String text, int shiftPos) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            encrypted.append(encode(text.charAt(i), shiftPos));
        }
        return encrypted.toString();
    }

    private static char encode(char ch, int shiftPos) {
        int currPos = TABLE.indexOf(ch);
        if (currPos < 0) {
            return ch;
        }
        int pos = currPos + shiftPos;
        if (pos > TABLE.length() - 1) {
            pos = pos - (TABLE.length());
        } else if (pos < 0) {
            pos = (TABLE.length()) + pos;
        }
        return TABLE.charAt(pos);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("ABC", 3));
        System.out.println(encrypt("DEF", -3));

        System.out.println(encrypt("A B C", 3));
        System.out.println(encrypt("D E F", -3));

        System.out.println(encrypt("XYZA", 3));
        System.out.println(encrypt("ABCD", -3));

        System.out.println(encrypt("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", -3));
    }
}
