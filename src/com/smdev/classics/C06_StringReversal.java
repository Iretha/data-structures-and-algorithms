package com.smdev.classics;

public class C06_StringReversal {

    /**
     * Shortest possible
     *
     * @param str
     * @return
     */
    private static String solution1(String str) {
        if (str == null) {
            return null;
        }
        return (new StringBuilder(str).reverse().toString());
    }

    /**
     * Fastest
     *
     * @param str
     * @return
     */
    private static String solution2(String str) {
        if (str == null) {
            return null;
        }
        char[] reversed = new char[str.length()];
        for (int i = 0; i <= str.length() / 2; i++) {
            reversed[i] = str.charAt(str.length() - 1 - i);
            reversed[str.length() - 1 - i] = str.charAt(i);
        }
        return String.valueOf(reversed);
    }


    public static void main(String[] args) {
        System.out.println("======= Shortest Solution: ======");
        System.out.println(solution1(null));
        System.out.println(solution1("abc"));

        System.out.println("======= Fastest Solution: ======");
        System.out.println(solution2(null));
        System.out.println(solution2("abc"));
        System.out.println(solution2("abcd"));
    }
}
