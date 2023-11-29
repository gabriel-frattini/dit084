package com.lab.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextIncompleteTests {

     // See report.txt for report

     @Test
     public void test_m_part1() {

          WorkSchedule workSchedule = new WorkSchedule(10);

          int currentTime = 1;
          workSchedule.setRequiredNumber(1, 3, 5);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // Next incomplete hour from 1 is 3
          assertEquals(3, nextIncomplete);
     }

     @Test
     public void test_m_part2() {

          WorkSchedule workSchedule = new WorkSchedule(10);

          int currentTime = 1;
          workSchedule.setRequiredNumber(1, 3, 5);
          workSchedule.addWorkingPeriod("TestEmployee", 3, 5);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // No incomplete hours
          assertEquals(-1, nextIncomplete);
     }

     @Test
     public void test_m_part3() {

          WorkSchedule workSchedule = new WorkSchedule(10);

          int currentTime = 1;
          workSchedule.setRequiredNumber(1, 3, 5);
          workSchedule.addWorkingPeriod("TestEmployee1", 3, 3);
          workSchedule.addWorkingPeriod("TestEmployee2", 4, 5);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // No incomplete hours
          assertEquals(-1, nextIncomplete);
     }

     @Test
     public void test_m_part4() {

          WorkSchedule workSchedule = new WorkSchedule(10);

          int currentTime = 1;
          workSchedule.setRequiredNumber(1, 3, 5);
          workSchedule.addWorkingPeriod("TestEmployee1", 3, 4);
          workSchedule.addWorkingPeriod("TestEmployee2", 4, 5);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // Hour 4 has too many employees, but no incomplete hours
          assertEquals(-1, nextIncomplete);
     }

     @Test
     public void test_m_part5() {

          WorkSchedule workSchedule = new WorkSchedule(10);

          int currentTime = 1;
          workSchedule.setRequiredNumber(1, 3, 5);
          workSchedule.setRequiredNumber(1, 6, 7);
          workSchedule.addWorkingPeriod("TestEmployee1", 3, 5);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // Next incomplete hour from 1 is 6
          assertEquals(6, nextIncomplete);
     }
}