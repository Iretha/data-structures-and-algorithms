package com.smdev.algorithm.general;

import com.smdev.algorithm.general.strings.T01_UniqueCharactersDetector;
import com.smdev.algorithm.general.strings.T02_PermutationDetector;
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
}
