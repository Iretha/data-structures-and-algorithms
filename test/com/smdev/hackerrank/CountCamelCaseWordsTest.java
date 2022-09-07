package com.smdev.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.hackerrank.com/challenges/camelcase/problem
 */
class CountCamelCaseWordsTest {

    @Test
    void testCamelCase() {
        Assertions.assertEquals(0, CountCamelCaseWords.camelcase(null));
        Assertions.assertEquals(0, CountCamelCaseWords.camelcase(""));
        Assertions.assertEquals(0, CountCamelCaseWords.camelcase("        "));

        Assertions.assertEquals(1, CountCamelCaseWords.camelcase("save"));
        Assertions.assertEquals(5, CountCamelCaseWords.camelcase("saveChangesInTheEditor"));
    }
}
