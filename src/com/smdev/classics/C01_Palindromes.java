package com.smdev.classics;

public class C01_Palindromes {
    private static boolean isPalindrome(String str) {
        if (str == null || str.length() == 1) {
            return false;
        }

        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("mom"));
        System.out.println(isPalindrome("dad"));
        System.out.println(isPalindrome("rush"));
        System.out.println(isPalindrome("yes"));
    }
}
