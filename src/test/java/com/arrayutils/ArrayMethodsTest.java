package com.arrayutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMethodsTest {

    @Test
    void map() {
        final Integer[] ints = {1, 2, 3, 4};
        final String[] expected1 = {"1", "2", "3", "4"};
        final Integer[] expected2 = {1, 4, 9, 16};
        assertArrayEquals(expected1, ArrayMethods.<Integer, String>map(ints, (n) -> n.toString()));
        assertArrayEquals(expected2, ArrayMethods.<Integer, Integer>map(ints, (n) -> n * n));
    }

    @Test
    void filter() {
        final Integer[] ints = {1, 2, 3, 4, 5, 6};
        final Integer[] expectedInts = {2, 4, 6};
        final String[] strings = {"ramu", "ravi", "brynn"};
        final String[] expectedStrings = {"ramu", "ravi"};
        assertArrayEquals(expectedInts, ArrayMethods.<Integer>filter(ints, (n) -> n % 2 == 0));
        assertArrayEquals(expectedStrings, ArrayMethods.filter(strings, s -> s.contains("a")));
    }

    @Test
    void reduce() {
        final Integer[] ints = {1, 2, 3, 4, 5, 6};
        assertEquals(21, ArrayMethods.<Integer, Integer>reduce(ints, 0, (c, n) -> c + n));
        assertEquals("123456", ArrayMethods.<Integer, String>reduce(ints, "", (c, n) -> c + n));
    }
}