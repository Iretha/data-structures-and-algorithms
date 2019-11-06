package com.smdev.hackerrank;

/**
 * https://www.hackerrank.com/challenges/camelcase/problem
 */
public class CountCamelCaseWords {

    // Complete the camelcase function below.
    static int camelcase(String s) {
        if(s == null || s.trim().length() == 0){
            return 0;
        }
        String[] strs = s.split("[A-Z]+");
        return strs.length;
    }

    public static void main(String[] args) {
        System.out.println(camelcase(null));
        System.out.println(camelcase(""));
        System.out.println(camelcase(" "));
        System.out.println(camelcase("save"));
        System.out.println(camelcase("saveChangesInTheEditor"));
    }
}
