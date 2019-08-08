package com.smdev.algorithm.general;

import com.smdev.algorithm.general.challenges.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

public class StringTests {

    @Test
    public void test_T01_UniqueCharacters() {
        test_T01_UniqueCharacters(T01_UniqueCharactersDetector::areCharsUnique);
        test_T01_UniqueCharacters(T01_UniqueCharactersDetector::areCharsUnique1);
    }

    private void test_T01_UniqueCharacters(Function<String, Boolean> func) {
        Assert.assertTrue(func.apply("aA"));
        Assert.assertTrue(func.apply("abcdABCD"));
        Assert.assertFalse(func.apply("abcdABCd"));
        Assert.assertTrue(func.apply(""));
        Assert.assertFalse(func.apply(null));
        Assert.assertFalse(func.apply("  "));
    }

    @Test
    public void test_T02_IsPermutation() {
        test_T02_IsPermutation(T02_PermutationDetector::isPermutation);
        test_T02_IsPermutation(T02_PermutationDetector::isPermutation1);
        test_T02_IsPermutation(T02_PermutationDetector::isPermutation2);
    }

    private void test_T02_IsPermutation(BiFunction<String, String, Boolean> func) {
        Assert.assertFalse(func.apply(null, null));
        Assert.assertFalse(func.apply("abcd", null));
        Assert.assertFalse(func.apply(null, "aadb"));
        Assert.assertTrue(func.apply("", ""));
        Assert.assertTrue(func.apply("a", "a"));
        Assert.assertFalse(func.apply("", "b"));
        Assert.assertFalse(func.apply("b", "a"));
        Assert.assertTrue(func.apply("abcd", "acdb"));
        Assert.assertFalse(func.apply("abcd", "Acdb"));
        Assert.assertFalse(func.apply("abcd", "aadb"));
    }

    @Test
    public void test_T03_Urlify() {
        test_T03_Urlify(T03_URLConvertor::urlify);
    }

    private void test_T03_Urlify(BiFunction<String, Integer, String> func) {
        Assert.assertNull(func.apply(null, 0));
        Assert.assertEquals("", func.apply("", 0));
        Assert.assertEquals("a%20b%20%20c%20d", func.apply(" a b  c d     ", 16));
        Assert.assertEquals("a%20b%20%20c%20d", func.apply(" a b  c d  \n   ", 16));
        Assert.assertEquals("abcd", func.apply("abcd", 4));
        Assert.assertEquals("a%20bcd", func.apply(" a bcd     ", 7));
        Assert.assertEquals("a%20bc%20d", func.apply("a bc d ", 10));
        Assert.assertEquals("a%20bc", func.apply("a bc d ", 6));
        Assert.assertEquals("a", func.apply("a bc d ", 1));
        Assert.assertEquals("a", func.apply("a bc d ", 2));
        Assert.assertEquals("a", func.apply("a bc d ", 3));
        Assert.assertEquals("a", func.apply("a bc d ", 4));
        Assert.assertEquals("a%20b", func.apply("a bc d ", 5));
        Assert.assertEquals("abcd", func.apply("abcd", 10));
    }

    @Test
    public void test_T04_OneAway() {
        // Challenge: There are three types of edits that can be performed on strings: insert a character,
        // remove a character, or replace a character. Given two strings, write a function to check if they are
        // one or zero edits away.

        // null checks
        Assert.assertFalse(T04_OneAway.oneAway(null, null));
        Assert.assertFalse(T04_OneAway.oneAway("pale", null));
        Assert.assertFalse(T04_OneAway.oneAway(null, "pale"));

        // empty checks
        Assert.assertTrue(T04_OneAway.oneAway("", ""));
        Assert.assertTrue(T04_OneAway.oneAway("", "a"));
        Assert.assertTrue(T04_OneAway.oneAway("b", ""));
        Assert.assertTrue(T04_OneAway.oneAway("c", "d"));

        // inserts
        Assert.assertTrue(T04_OneAway.oneAway("abc", "Dabc"));
        Assert.assertTrue(T04_OneAway.oneAway("abc", "abcD"));
        Assert.assertTrue(T04_OneAway.oneAway("abc", "abDc"));

        // deletes
        Assert.assertTrue(T04_OneAway.oneAway("abc", "bc"));
        Assert.assertTrue(T04_OneAway.oneAway("abc", "ab"));
        Assert.assertTrue(T04_OneAway.oneAway("abc", "ac"));
        Assert.assertFalse(T04_OneAway.oneAway("abc", "a"));

        // replaces
        Assert.assertTrue(T04_OneAway.oneAway("abc", "Abc"));
        Assert.assertTrue(T04_OneAway.oneAway("abc", "aBc"));
        Assert.assertTrue(T04_OneAway.oneAway("abc", "abC"));

        // equal
        Assert.assertTrue(T04_OneAway.oneAway("abc", "abc"));

        // other
        Assert.assertFalse(T04_OneAway.oneAway("abc", "abCCCC"));
        Assert.assertFalse(T04_OneAway.oneAway("abc", "klp"));
        Assert.assertFalse(T04_OneAway.oneAway("abc", "kl"));
        Assert.assertFalse(T04_OneAway.oneAway("abc", "kmlop"));

        // random
        Assert.assertFalse(T04_OneAway.oneAway("pale", "paleXXXX"));
        Assert.assertTrue(T04_OneAway.oneAway("pale", "ple"));
        Assert.assertTrue(T04_OneAway.oneAway("pales", "pale"));
        Assert.assertTrue(T04_OneAway.oneAway("pale", "bale"));
        Assert.assertFalse(T04_OneAway.oneAway("pale", "bake"));
        Assert.assertTrue(T04_OneAway.oneAway("pale", "aale"));
        Assert.assertTrue(T04_OneAway.oneAway("pale", "pble"));
        Assert.assertTrue(T04_OneAway.oneAway("pale", "palk"));
        Assert.assertFalse(T04_OneAway.oneAway("pale", "bakeerer"));
    }

    @Test
    public void test_T05_Compressor() {
        // Challenge: Give a string with repeating characters (i.e. "aaabb") write
        // an algorithm that will compress the string down to the character, followed
        // by the number of times it appears in the string (i.e "a3b2").
        // If the compressed string is not smaller than original, return original.

        Assert.assertNull(T05_Compressor.compress(null));
        Assert.assertEquals("", T05_Compressor.compress(""));
        Assert.assertEquals("a", T05_Compressor.compress("a"));
        Assert.assertEquals("aa", T05_Compressor.compress("aa"));
        Assert.assertEquals("a3", T05_Compressor.compress("aaa"));

        Assert.assertEquals("a3b2", T05_Compressor.compress("aaabb"));
        Assert.assertEquals("aabb", T05_Compressor.compress("aabb"));
        Assert.assertEquals("ab", T05_Compressor.compress("ab"));
        Assert.assertEquals("abc", T05_Compressor.compress("abc"));
        Assert.assertEquals("z3", T05_Compressor.compress("zzz"));
        Assert.assertEquals("aabbaabb", T05_Compressor.compress("aabbaabb")); // not shorter
    }

}
