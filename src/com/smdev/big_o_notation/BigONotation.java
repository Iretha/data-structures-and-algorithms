package com.smdev.big_o_notation;

import java.util.List;

public class BigONotation {

    public void doExample_0(int a, int b) {
        if (a < b) { // O(1)
            // do something here
        }
        // => O(1)
    }

    public void doExample_1(String[] arr1) {
        for (int i = 0; i < arr1.length; i++) { // O(N)
            // do something here
        }

        // => O(N)
    }

    public void doExample_2(String[] arr1) {
        for (int i = 0; i < arr1.length; i++) { // O(N)
            doExample_0(i, 2); // O(1)
            if (i > 5) { // O(1)
                // do something here
            }
        }

        // => O(N + 1 + 1) > O(N)
    }

    public void doExample_3(String[] arr1) {
        doExample_1(arr1); // O(N)
        for (int i = 0; i < arr1.length / 2; i++) { // O(N/2) => O(N)
            // do something here
        }

        // => O(N + N) > O(2N) > O(N)
    }

    public void doExample_4(String[] arr1) {
        doExample_1(arr1); // 0(N)
        doExample_2(arr1); // 0(N)
        doExample_3(arr1); // 0(N)

        // => O(N + N + N) > O(3N) > O(N)
    }

    public void doExample_5(String[] arr1) {
        for (int i = 0; i < arr1.length; i++) { // O(N)
            for (int j = 0; j < arr1.length; j++) { // O(N)
                // do something here
            }
        }

        // => O(N * N) > O(N^2)
    }

    public void doExample_6(String[] arr1) {
        for (int i = 0; i < arr1.length; i++) { // O(N)
            for (int j = 0; j < arr1.length / 2; j++) { // O(N / 2) => O(N)
                // do something here
            }
        }

        // => O(N * N) > O(N^2)
    }

    public void doExample_7(String[] arr1) {
        for (int i = 0; i < arr1.length; i++) { // O(N)
            for (int j = 0; j < arr1.length; j++) { // O(N)
                for (int n = 0; j < arr1.length / 2; n++) {// O(N / 2) => O(N)
                    // do something here
                }
            }
        }

        // => O(N * N * N) > O(N^3)
    }

    public void doExample_8(String[] arr1, String[] arr2) {
        doExample_1(arr1); // O(N)
        doExample_2(arr2); // O(M)
        doExample_3(arr2); // O(M)

        // => O(N + M + M) > O(N + 2M) > O(N + M)
    }

    public void doExample_9(String[] arr1, String[] arr2) {
        doExample_1(arr1); // O(N)
        doExample_6(arr1); // O(N^2)
        doExample_7(arr2); // O(M^3)

        // => O(N + N^2 + M^3) > O(2N^2 + M^3) > O(N^2 + M^3)
    }

    public void doExample_10(String[] arr1, String[] arr2) {
        for (int i = 0; i < arr1.length; i++) { // O(N)
            for (int j = 0; j < arr2.length * 2; j++) { // O(M * 2) => 0(M)
                // do something here
            }
        }
        // => O(N * M)
    }

    public void doExample_11(List<String> list1) {
        for (int i = 0; i < list1.size(); i++) { // O(N)
            // do something here
        }

        List<String> list2 = list1.subList(0, list1.size() / 3);
        for (int j = 0; j < list2.size() * 2; j++) { // O(M * 2) => 0(M)
            // do something here
        }

        // => O(N + M) => 0(N) (because N is the dominant one, and we drop the other)
    }

    public void doExample_12(List<String> list1) {
        List<String> list2 = list1.subList(0, list1.size() / 6);

        for (int i = 0; i < list1.size(); i++) { // O(N)
            for (int j = 0; j < list2.size() * 2; j++) { // O(M * 2) => 0(M)
                // do something here
            }
        }

        // => O(N * M) => 0(N) (because N is the dominant one, and we drop the other)
    }

    public void doExample_13(int n) {
        for (int x = n; x >= 1; x = x / 2) { // O(log N)
            // do something here
        }

        // => O(log N)
    }

    public void doExample_14(int n) {
        for (int i = 0; i < n; i++) { // O(N)
            // do something here
        }
        for (int x = n; x >= 1; x = x / 2) { // O(log N)
            // do something here
        }

        // => O(N + log N) => O(N) (drop the non-dominant)
    }
}
