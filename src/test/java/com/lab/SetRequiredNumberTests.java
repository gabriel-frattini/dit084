package com.lab;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SetRequiredNumberTests {

     // See report.txt for report

     @Test
     public void test_m_part1() {
          int nemployee = 0;
          int starttime = 1;
          int endtime = 0;

          // Preparation, creates a WorkSchedule (with hour 0 and 1) and adds one employee
          WorkSchedule workSchedule = new WorkSchedule(2);
          workSchedule.setRequiredNumber(1, 0, 1);
          workSchedule.addWorkingPeriod("TestEmployee", 0, 1);

          // Saves schedule before call, calls setRequiredNumber, saves schedule after call
          Hour scheduleHour0Before = workSchedule.readSchedule(0);
          Hour scheduleHour1Before = workSchedule.readSchedule(1);
          workSchedule.setRequiredNumber(nemployee, starttime, endtime);
          Hour scheduleHour0After = workSchedule.readSchedule(0);
          Hour scheduleHour1After = workSchedule.readSchedule(1);

          // Test
          assertEquals(scheduleHour0Before.requiredNumber, scheduleHour0After.requiredNumber);
          assertEquals(scheduleHour1Before.requiredNumber, scheduleHour1After.requiredNumber);
          assertArrayEquals(scheduleHour0Before.workingEmployees, scheduleHour0After.workingEmployees);
          assertArrayEquals(scheduleHour1Before.workingEmployees, scheduleHour1After.workingEmployees);
     }

     @Test
     public void test_m_part2() {
          int nemployee = 0;
          int starttime = 0;
          int endtime = 0;

          // Preparation, creates a WorkSchedule (with hour 0 and 1) and adds one employee
          WorkSchedule workSchedule = new WorkSchedule(2);
          workSchedule.setRequiredNumber(1, 0, 1);
          workSchedule.addWorkingPeriod("TestEmployee", 0, 1);

          // Saves schedule before call, calls setRequiredNumber, saves schedule after call
          Hour scheduleHour1Before = workSchedule.readSchedule(1);
          workSchedule.setRequiredNumber(nemployee, starttime, endtime);
          Hour scheduleHour0After = workSchedule.readSchedule(0);
          Hour scheduleHour1After = workSchedule.readSchedule(1);

          // Test for hour 0
          assertEquals(nemployee, scheduleHour0After.requiredNumber);
          assertEquals(nemployee, scheduleHour0After.workingEmployees.length);

          // Test for rest of the schedule (hour 1)
          assertEquals(scheduleHour1Before.requiredNumber, scheduleHour1After.requiredNumber);
          assertArrayEquals(scheduleHour1Before.workingEmployees, scheduleHour1After.workingEmployees);
     }

     @Test
     public void test_m_part3() {
          int nemployee = 0;
          int starttime = 0;
          int endtime = 1;

          // Preparation, creates a WorkSchedule (with hour 0, 1 and 2) and adds one employee
          WorkSchedule workSchedule = new WorkSchedule(3);
          workSchedule.setRequiredNumber(1, 0, 2);
          workSchedule.addWorkingPeriod("TestEmployee", 0, 2);

          // Saves schedule before call, calls setRequiredNumber, saves schedule after call
          Hour scheduleHour2Before = workSchedule.readSchedule(2);
          workSchedule.setRequiredNumber(nemployee, starttime, endtime);
          Hour scheduleHour0After = workSchedule.readSchedule(0);
          Hour scheduleHour1After = workSchedule.readSchedule(1);
          Hour scheduleHour2After = workSchedule.readSchedule(2);

          // Test for hour 0 and 1
          assertEquals(nemployee, scheduleHour0After.requiredNumber);
          assertEquals(nemployee, scheduleHour0After.workingEmployees.length);
          assertEquals(nemployee, scheduleHour1After.requiredNumber);
          assertEquals(nemployee, scheduleHour1After.workingEmployees.length);

          // Test for rest of the schedule (hour 2)
          assertEquals(scheduleHour2Before.requiredNumber, scheduleHour2After.requiredNumber);
          assertArrayEquals(scheduleHour2Before.workingEmployees, scheduleHour2After.workingEmployees);
     }

     @Test
     public void test_m_part4() {
          int nemployee = 2;
          int starttime = 1;
          int endtime = 0;

          // Preparation, creates a WorkSchedule (with hour 0 and 1) and adds one employee
          WorkSchedule workSchedule = new WorkSchedule(2);
          workSchedule.setRequiredNumber(1, 0, 1);
          workSchedule.addWorkingPeriod("TestEmployee", 0, 1);

          // Saves schedule before call, calls setRequiredNumber, saves schedule after call
          Hour scheduleHour0Before = workSchedule.readSchedule(0);
          Hour scheduleHour1Before = workSchedule.readSchedule(1);
          workSchedule.setRequiredNumber(nemployee, starttime, endtime);
          Hour scheduleHour0After = workSchedule.readSchedule(0);
          Hour scheduleHour1After = workSchedule.readSchedule(1);

          // Test
          assertEquals(scheduleHour0Before.requiredNumber, scheduleHour0After.requiredNumber);
          assertEquals(scheduleHour1Before.requiredNumber, scheduleHour1After.requiredNumber);
          assertArrayEquals(scheduleHour0Before.workingEmployees, scheduleHour0After.workingEmployees);
          assertArrayEquals(scheduleHour1Before.workingEmployees, scheduleHour1After.workingEmployees);
     }

     @Test
     public void test_m_part5() {
          int nemployee = 2;
          int starttime = 0;
          int endtime = 0;

          // Preparation, creates a WorkSchedule (with hour 0 and 1) and adds one employee
          WorkSchedule workSchedule = new WorkSchedule(2);
          workSchedule.setRequiredNumber(1, 0, 1);
          workSchedule.addWorkingPeriod("TestEmployee", 0, 1);

          // Saves schedule before call, calls setRequiredNumber, saves schedule after call
          Hour scheduleHour0Before = workSchedule.readSchedule(0);
          Hour scheduleHour1Before = workSchedule.readSchedule(1);
          workSchedule.setRequiredNumber(nemployee, starttime, endtime);
          Hour scheduleHour0After = workSchedule.readSchedule(0);
          Hour scheduleHour1After = workSchedule.readSchedule(1);

          // Test for hour 0
          assertEquals(nemployee, scheduleHour0After.requiredNumber);
          assertArrayEquals(scheduleHour0Before.workingEmployees, scheduleHour0After.workingEmployees);

          // Test for rest of the schedule (hour 1)
          assertEquals(scheduleHour1Before.requiredNumber, scheduleHour1After.requiredNumber);
          assertArrayEquals(scheduleHour1Before.workingEmployees, scheduleHour1After.workingEmployees);
     }

     @Test
     public void test_m_part6() {
          int nemployee = 2;
          int starttime = 0;
          int endtime = 1;

          // Preparation, creates a WorkSchedule (with hour 0, 1 and 2) and adds one employee
          WorkSchedule workSchedule = new WorkSchedule(3);
          workSchedule.setRequiredNumber(1, 0, 2);
          workSchedule.addWorkingPeriod("TestEmployee", 0, 2);

          // Saves schedule before call, calls setRequiredNumber, saves schedule after call
          Hour scheduleHour0Before = workSchedule.readSchedule(0);
          Hour scheduleHour1Before = workSchedule.readSchedule(1);
          Hour scheduleHour2Before = workSchedule.readSchedule(2);
          workSchedule.setRequiredNumber(nemployee, starttime, endtime);
          Hour scheduleHour0After = workSchedule.readSchedule(0);
          Hour scheduleHour1After = workSchedule.readSchedule(1);
          Hour scheduleHour2After = workSchedule.readSchedule(2);

          // Test for hour 0 and 1
          assertEquals(nemployee, scheduleHour0After.requiredNumber);
          assertArrayEquals(scheduleHour0Before.workingEmployees, scheduleHour0After.workingEmployees);
          assertEquals(nemployee, scheduleHour1After.requiredNumber);
          assertArrayEquals(scheduleHour1Before.workingEmployees, scheduleHour1After.workingEmployees);

          // Test for rest of the schedule (hour 2)
          assertEquals(scheduleHour2Before.requiredNumber, scheduleHour2After.requiredNumber);
          assertArrayEquals(scheduleHour2Before.workingEmployees, scheduleHour2After.workingEmployees);
     }
}