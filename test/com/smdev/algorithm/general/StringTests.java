package com.smdev.algorithm.general;

import com.smdev.algorithm.general.challenges.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

class StringTests {

    @Test
    void test_T01_UniqueCharacters() {
        test_T01_UniqueCharacters(T01_UniqueCharactersDetector::areCharsUnique);
        test_T01_UniqueCharacters(T01_UniqueCharactersDetector::areCharsUnique1);
    }

    private void test_T01_UniqueCharacters(Function<String, Boolean> func) {
        Assertions.assertTrue(func.apply("aA"));
        Assertions.assertTrue(func.apply("abcdABCD"));
        Assertions.assertFalse(func.apply("abcdABCd"));
        Assertions.assertTrue(func.apply(""));
        Assertions.assertFalse(func.apply(null));
        Assertions.assertFalse(func.apply("  "));
    }

    @Test
    void test_T02_IsPermutation() {
        test_T02_IsPermutation(T02_PermutationDetector::isPermutation);
        test_T02_IsPermutation(T02_PermutationDetector::isPermutation1);
        test_T02_IsPermutation(T02_PermutationDetector::isPermutation2);
    }

    private void test_T02_IsPermutation(BiFunction<String, String, Boolean> func) {
        Assertions.assertFalse(func.apply(null, null));
        Assertions.assertFalse(func.apply("abcd", null));
        Assertions.assertFalse(func.apply(null, "aadb"));
        Assertions.assertTrue(func.apply("", ""));
        Assertions.assertTrue(func.apply("a", "a"));
        Assertions.assertFalse(func.apply("", "b"));
        Assertions.assertFalse(func.apply("b", "a"));
        Assertions.assertTrue(func.apply("abcd", "acdb"));
        Assertions.assertFalse(func.apply("abcd", "Acdb"));
        Assertions.assertFalse(func.apply("abcd", "aadb"));
    }

    @Test
    void test_T03_Urlify() {
        test_T03_Urlify(T03_URLConvertor::urlify);
    }

    private void test_T03_Urlify(BiFunction<String, Integer, String> func) {
        Assertions.assertNull(func.apply(null, 0));
        Assertions.assertEquals("", func.apply("", 0));
        Assertions.assertEquals("a%20b%20%20c%20d", func.apply(" a b  c d     ", 16));
        Assertions.assertEquals("a%20b%20%20c%20d", func.apply(" a b  c d  \n   ", 16));
        Assertions.assertEquals("abcd", func.apply("abcd", 4));
        Assertions.assertEquals("a%20bcd", func.apply(" a bcd     ", 7));
        Assertions.assertEquals("a%20bc%20d", func.apply("a bc d ", 10));
        Assertions.assertEquals("a%20bc", func.apply("a bc d ", 6));
        Assertions.assertEquals("a", func.apply("a bc d ", 1));
        Assertions.assertEquals("a", func.apply("a bc d ", 2));
        Assertions.assertEquals("a", func.apply("a bc d ", 3));
        Assertions.assertEquals("a", func.apply("a bc d ", 4));
        Assertions.assertEquals("a%20b", func.apply("a bc d ", 5));
        Assertions.assertEquals("abcd", func.apply("abcd", 10));
    }

    @Test
    void test_T04_OneAway() {
        // Challenge: There are three types of edits that can be performed on strings: insert a character,
        // remove a character, or replace a character. Given two strings, write a function to check if they are
        // one or zero edits away.

        // null checks
        Assertions.assertFalse(T04_OneAway.oneAway(null, null));
        Assertions.assertFalse(T04_OneAway.oneAway("pale", null));
        Assertions.assertFalse(T04_OneAway.oneAway(null, "pale"));

        // empty checks
        Assertions.assertTrue(T04_OneAway.oneAway("", ""));
        Assertions.assertTrue(T04_OneAway.oneAway("", "a"));
        Assertions.assertTrue(T04_OneAway.oneAway("b", ""));
        Assertions.assertTrue(T04_OneAway.oneAway("c", "d"));

        // inserts
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "Dabc"));
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "abcD"));
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "abDc"));

        // deletes
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "bc"));
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "ab"));
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "ac"));
        Assertions.assertFalse(T04_OneAway.oneAway("abc", "a"));

        // replaces
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "Abc"));
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "aBc"));
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "abC"));

        // equal
        Assertions.assertTrue(T04_OneAway.oneAway("abc", "abc"));

        // other
        Assertions.assertFalse(T04_OneAway.oneAway("abc", "abCCCC"));
        Assertions.assertFalse(T04_OneAway.oneAway("abc", "klp"));
        Assertions.assertFalse(T04_OneAway.oneAway("abc", "kl"));
        Assertions.assertFalse(T04_OneAway.oneAway("abc", "kmlop"));

        // random
        Assertions.assertFalse(T04_OneAway.oneAway("pale", "paleXXXX"));
        Assertions.assertTrue(T04_OneAway.oneAway("pale", "ple"));
        Assertions.assertTrue(T04_OneAway.oneAway("pales", "pale"));
        Assertions.assertTrue(T04_OneAway.oneAway("pale", "bale"));
        Assertions.assertFalse(T04_OneAway.oneAway("pale", "bake"));
        Assertions.assertTrue(T04_OneAway.oneAway("pale", "aale"));
        Assertions.assertTrue(T04_OneAway.oneAway("pale", "pble"));
        Assertions.assertTrue(T04_OneAway.oneAway("pale", "palk"));
        Assertions.assertFalse(T04_OneAway.oneAway("pale", "bakeerer"));
    }

    @Test
    void test_T05_Compressor() {
        // Challenge: Give a string with repeating characters (i.e. "aaabb") write
        // an algorithm that will compress the string down to the character, followed
        // by the number of times it appears in the string (i.e "a3b2").
        // If the compressed string is not smaller than original, return original.

        Assertions.assertNull(T05_Compressor.compress(null));
        Assertions.assertEquals("", T05_Compressor.compress(""));
        Assertions.assertEquals("a", T05_Compressor.compress("a"));
        Assertions.assertEquals("aa", T05_Compressor.compress("aa"));
        Assertions.assertEquals("a3", T05_Compressor.compress("aaa"));

        Assertions.assertEquals("a3b2", T05_Compressor.compress("aaabb"));
        Assertions.assertEquals("aabb", T05_Compressor.compress("aabb"));
        Assertions.assertEquals("ab", T05_Compressor.compress("ab"));
        Assertions.assertEquals("abc", T05_Compressor.compress("abc"));
        Assertions.assertEquals("z3", T05_Compressor.compress("zzz"));
        Assertions.assertEquals("aabbaabb", T05_Compressor.compress("aabbaabb")); // not shorter
    }

}
