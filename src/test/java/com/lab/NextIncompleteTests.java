package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NextIncompleteTests {

     @Test
     public void test_m_part1() {

          WorkSchedule workSchedule = new WorkSchedule(2);
          int currenttime = 0;
          workSchedule.setRequiredNumber(1, currenttime, 1);

          int starttime = workSchedule.nextIncomplete(currenttime);

          assertEquals(currenttime + 1, starttime);
     }

     @Test
     public void test_m_part2() {

          WorkSchedule workSchedule = new WorkSchedule(7); // Index out of bounds exception if it is <= 7
          int currenttime = 5;
          workSchedule.setRequiredNumber(1, currenttime, 6);

          int starttime = workSchedule.nextIncomplete(currenttime);

          // Next incomplete hour from 5 is 6
          assertEquals(currenttime + 1, starttime);
     }
}
