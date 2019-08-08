package com.smdev.algorithm.general;

import com.smdev.algorithm.general.strings.T01_UniqueCharactersDetector;
import com.smdev.algorithm.general.strings.T02_PermutationDetector;
import org.junit.Assert;
import org.junit.Test;

public class StringTests {

    @Test
    public void test_T01_UniqueCharacters() {
        Assert.assertTrue(T01_UniqueCharactersDetector.areCharsUnique("abcdABCD"));
        Assert.assertFalse(T01_UniqueCharactersDetector.areCharsUnique("abcdABCd"));
        Assert.assertTrue(T01_UniqueCharactersDetector.areCharsUnique(""));
        Assert.assertFalse(T01_UniqueCharactersDetector.areCharsUnique(null));
        Assert.assertFalse(T01_UniqueCharactersDetector.areCharsUnique("  "));
    }

    @Test
    public void test_T02_IsPermutation() {
        Assert.assertFalse(T02_PermutationDetector.isPermutation(null, null));
        Assert.assertFalse(T02_PermutationDetector.isPermutation("abcd", null));
        Assert.assertFalse(T02_PermutationDetector.isPermutation(null, "aadb"));
        Assert.assertTrue(T02_PermutationDetector.isPermutation("", ""));
        Assert.assertTrue(T02_PermutationDetector.isPermutation("a", "a"));
        Assert.assertFalse(T02_PermutationDetector.isPermutation("", "b"));
        Assert.assertFalse(T02_PermutationDetector.isPermutation("b", "a"));
        Assert.assertTrue(T02_PermutationDetector.isPermutation("abcd", "acdb"));
        Assert.assertFalse(T02_PermutationDetector.isPermutation("abcd", "Acdb"));
        Assert.assertFalse(T02_PermutationDetector.isPermutation("abcd", "aadb"));
    }
}
