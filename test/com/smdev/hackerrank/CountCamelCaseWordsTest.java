package com.smdev.hackerrank;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/camelcase/problem
 */
public class CountCamelCaseWordsTest {

    @Test
    public void testCamelCase() {
        Assert.assertEquals(0, CountCamelCaseWords.camelcase(null));
        Assert.assertEquals(0, CountCamelCaseWords.camelcase(""));
        Assert.assertEquals(0, CountCamelCaseWords.camelcase("        "));

        Assert.assertEquals(1, CountCamelCaseWords.camelcase("save"));
        Assert.assertEquals(5, CountCamelCaseWords.camelcase("saveChangesInTheEditor"));
    }
}
