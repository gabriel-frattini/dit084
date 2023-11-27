package com.lab;

import java.util.*;
import java.util.function.IntBinaryOperator;

public class Set {

     private final ArrayList<Integer> a;

     public Set() {
          a = new ArrayList<Integer>();
     }

     public int[] toArray() {
          int[] ia = new int[a.size()];
          for (int i = 0; i < ia.length; i++) {
               ia[i] = a.get(i);
          }
          return ia;
     }

     public void insert(int x) {
          for (int i = 0; i < a.size(); i++) {
               if (a.get(i) > x) {
                    a.add(i, x);
                    return;
               }
               else {
                    if (a.get(i) == x) {
                         return;
                    }
               }
          }
          a.add(x);
     }

     public boolean member(int x) {
          for (int i = 0; i < a.size(); i++) {
               if (a.get(i) > x) {
                    return false;
               }
               else {
                    if (a.get(i) == x) {
                         return true;
                    }
               }
          }
          return false;
     }

     public void intersect(Set s) {
          int i = 0;
          int j = 0;
          if (s.a.isEmpty()) {
               a.clear();
               return;
          }
          while (true) {
               if (a.get(i) != s.a.get(j)) {
                    a.remove(i);
                    i--;
               }
               i++;
               if (j < s.a.size() - 1) {
                    j++;
               }
               if (i > a.size() - 1) {
                    break;
               }
          }
     }

     public boolean distinctClosed(IntBinaryOperator f) {
          int vi, vj;
          for (int i = 0; i < a.size(); i++) {
               for (int j = i; j < a.size(); j++) {
                    if(i == j) {
                         continue;
                    }
                    vi = a.get(i);
                    vj = a.get(j);
                    if (!(member(f.applyAsInt(vi, vj))))
                         return false;
               }
          }
          return true;
     }
}
