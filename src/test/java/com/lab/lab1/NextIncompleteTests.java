package com.lab.lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextIncompleteTests {

     // See report.txt for report

     @Test
     public void test_m_part1() {

          WorkSchedule workSchedule = new WorkSchedule(10);

          int currentTime = 0;
          workSchedule.setRequiredNumber(1, 3, 5);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // Next incomplete hour from 0 is 1
          assertEquals(3, nextIncomplete);
     }

     @Test
     public void test_m_part2() {

          WorkSchedule workSchedule = new WorkSchedule(10);

          int currentTime = 1;
          workSchedule.setRequiredNumber(1, 3, 5);
          int nextIncomplete = workSchedule.nextIncomplete(currentTime);

          // Next incomplete hour from 1 is 3
          assertEquals(3, nextIncomplete);
     }
}