package com.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.*;

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
     public void shouldIntersectSmallerArray() {
          Set s = new Set();
          s.insert(0);
          s.insert(1);
          s.insert(2);

          Set s2 = new Set();
          s2.insert(1);

          s.intersect(s2);

          assertArrayEquals(s2.toArray(), s.toArray());
     }

     @Test
     public void shouldIntersectLargerArray() {
          Set s = new Set();
          s.insert(0);

          Set s2 = new Set();
          s2.insert(1);
          s2.insert(2);
          s2.insert(3);

          s.intersect(s2);

          assertArrayEquals(new int[] {}, s.toArray());
     }

     @Test
     public void shouldIntersectSameValuesInBothArrays() {
          Set s = new Set();
          s.insert(0);
          s.insert(1);

          Set s2 = new Set();
          s2.insert(0);
          s2.insert(1);

          s.intersect(s2);

          assertArrayEquals(s2.toArray(), s.toArray());
     }

     @Test
     public void shouldIntersectWithEmptyArray() {
          Set s = new Set();
          s.insert(0);
          s.insert(1);

          Set s2 = new Set();

          s.intersect(s2);

          assertArrayEquals(new int[] {}, s.toArray());
     }

     @Test
     public void shouldIntersectEmptyArray() {
          Set s = new Set();

          Set s2 = new Set();
          s.insert(0);
          s.insert(1);

          s.intersect(s2);

          assertArrayEquals(new int[] {}, s.toArray());
     }

     /******************
      * distinctClosed Tests
      ******************/
     @Test
     public void distinctClosedTrue() {
          Set s = new Set();
          s.insert(0);
          s.insert(1);

          IntBinaryOperator f = (a, b) -> a + b;

          assertTrue(s.distinctClosed(f));
     }

     @Test
     public void distinctClosedFalse() {
          Set s = new Set();
          s.insert(1);
          s.insert(2);

          IntBinaryOperator f = (a, b) -> a + b;

          assertFalse(s.distinctClosed(f));
     }
}
