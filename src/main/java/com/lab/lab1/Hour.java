package com.lab;

import java.util.Arrays;

public class Hour {
     public int requiredNumber;
     public String[] workingEmployees;

     public Hour(int requiredNumber) {
          this.requiredNumber = requiredNumber;
          this.workingEmployees = new String[0];
     }

     public boolean checkEmployee(String name) {
          boolean res = true;
          if (this.workingEmployees.length < this.requiredNumber) {
               for (int i = 0; i < this.workingEmployees.length; ++i) {
                    if (this.workingEmployees[i].equals(name)) {
                         res = false;
                         break;
                    }
               }
          } else {
               res = false;
          }

          return res;
     }

     public void addEmployee(String name) {
          if (this.workingEmployees.length < this.requiredNumber) {
               this.workingEmployees = (String[]) Arrays.copyOf(this.workingEmployees,
                         this.workingEmployees.length + 1);
               this.workingEmployees[this.workingEmployees.length - 1] = name;
          }

     }
}
