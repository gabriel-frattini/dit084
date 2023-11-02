package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SetTests {

     @Test
     public void insertShouldIncreaseSize() {
          Set s = new Set();
          s.insert(0);
          assertEquals(s.toArray().length, 1);
     }

     @Test
     public void shouldInsert() {
          Set s = new Set();
          s.insert(0);
          int[] expected = { 0 };
          assertArrayEquals(s.toArray(), expected);
     }

     @Test
     public void insertShouldHaveMember() {
          Set s = new Set();
          s.insert(0);
          assertTrue(s.member(0));
     }

     @Test
     public void insertShouldNotEmptySet() {
          Set s = new Set();
          s.insert(0);
          assertNotEquals(s.toArray().length, 0);
     }
}
