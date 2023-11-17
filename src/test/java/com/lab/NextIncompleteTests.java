package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextIncompleteTests {

     // See report.txt for report

     @Test
     public void test_m_part1() {

          WorkSchedule workSchedule = new WorkSchedule(3);

          int currentTime = 0;
          workSchedule.setRequiredNumber(1, currentTime, 1);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // Next incomplete hour from 0 is 1
          assertEquals(currentTime + 1, nextIncomplete);
     }

     @Test
     public void test_m_part2() {

          // Index out of bounds exception if it is <= 4
          WorkSchedule workSchedule = new WorkSchedule(4);

          int currentTime = 1;
          workSchedule.setRequiredNumber(1, currentTime, 2);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // Next incomplete hour from 1 is 2
          assertEquals(currentTime + 1, nextIncomplete);
     }
}