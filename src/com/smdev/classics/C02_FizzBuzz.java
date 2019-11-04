package com.smdev.classics;

public class C02_FizzBuzz {


    private static void printRange(int min, int max) {
        for (int i = min; i <= max; i++) {
            print(i);
        }
    }

    private static void print(int i) {
        boolean fizz = i % 3 == 0;
        boolean buzz = i % 5 == 0;

        if (fizz && buzz) {
            System.out.println("FizzBuzz");
        } else if (fizz) {
            System.out.println("Fizz");
        } else if (buzz) {
            System.out.println("Buzz");
        } else {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printRange(1, 100);
    }
}
