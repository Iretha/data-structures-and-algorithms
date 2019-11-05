package com.smdev.classics;

public class C07_IntegerReversal {

    /**
     * Shortest Solution
     *
     * @param i
     * @return
     */
    private static int reverse1(int i) {
        boolean negative = i < 0;
        int num = Math.abs(i);
        int reversed = Integer.valueOf((new StringBuilder(String.valueOf(num))).reverse().toString());
        return negative ? reversed * -1 : reversed;
    }

    /**
     * More elegant solution
     *
     * @param num
     * @return
     */
    private static int reverse2(int num) {
        boolean negative = num < 0;
        num = Math.abs(num);
        int reversed = 0;
        while (num > 0) {
            reversed = (reversed * 10) + (num % 10);
            num = num / 10;
        }
        return negative ? reversed * -1 : reversed;
    }


    public static void main(String[] args) {
        System.out.println(reverse1(1230)); // 321
        System.out.println(reverse1(-123)); // -321

        System.out.println(reverse2(1230)); // 321
        System.out.println(reverse2(-123)); // -321
    }
}
