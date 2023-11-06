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

     /******************
      * Insert Tests
      ******************/
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
     public void shouldInsertInAscendingOrder() {
          Set s = new Set();
          s.insert(1);
          s.insert(0);
          int[] expected = { 0, 1 };
          assertArrayEquals(expected, s.toArray());
     }

     @Test
     public void shouldInsertInDescendingOrder() {
          Set s = new Set();
          s.insert(0);
          s.insert(1);
          int[] expected = { 0, 1 };
          assertArrayEquals(expected, s.toArray());
     }

     @Test
     public void shouldInsertSameValues() {
          Set s = new Set();
          s.insert(0);
          s.insert(0);
          int[] expected = { 0, 0 };
          assertArrayEquals(expected, s.toArray());
     }

     @Test
     public void insertShouldNotHaveEmptySet() {
          Set s = new Set();
          s.insert(0);
          assertNotEquals(s.toArray().length, 0);
     }

     /******************
      * Member Tests
      ******************/
     @Test
     public void insertShouldHaveMember() {
          Set s = new Set();
          s.insert(0);
          assertTrue(s.member(0));
     }

     @Test
     public void emptySetShouldHaveNoMember() {
          Set s = new Set();
          assertTrue(s.member(0) == false);
     }

     @Test
     public void insertShouldNotHaveMemberWithHigherValue() {
          Set s = new Set();
          s.insert(0);
          assertTrue(s.member(1) == false);
     }

     @Test
     public void insertShouldNotHaveMemberWithLowerValue() {
          Set s = new Set();
          s.insert(1);
          assertTrue(s.member(0) == false);
     }

     /******************
      * Intersect Tests
      ******************/
     @Test
     public void intersect() {
          Set s = new Set();
          s.insert(0);
          s.insert(1);
          s.insert(2);

          Set s2 = new Set();
          s2.insert(1);

          s.intersect(s2);

          // assertArrayEquals(s2.toArray(), s.toArray());
     }

}
