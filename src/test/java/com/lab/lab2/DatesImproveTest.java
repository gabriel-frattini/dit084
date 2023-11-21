package com.lab.lab2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class DatesImproveTest {

     @Test
     public void test30DaysBetween() {

          String startMonth = "1";
          String startDay = "1";
          String endMonth = "1";
          String endDay = "30";
          String[] input = { startMonth, startDay, endMonth, endDay };

          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          System.setOut(new PrintStream(baos));

          DatesImprove.main(input);
          String output = baos.toString();

          String[] contents = output.split("\n");
          String content = contents[contents.length - 1];
          try {
               Integer actual = Integer.parseInt(content);
               Integer expected = 29;
               assertEquals(expected, actual);

          } catch (Exception e) {
               System.out.println("Could not parse int -> " + e);
          }

     }

     @Test
     public void test1DaysInBetween() {

          String startMonth = "1";
          String startDay = "1";
          String endMonth = "1";
          String endDay = "2";
          String[] input = { startMonth, startDay, endMonth, endDay };

          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          System.setOut(new PrintStream(baos));

          DatesImprove.main(input);
          String output = baos.toString();

          String[] contents = output.split("\n");
          String content = contents[contents.length - 1];
          try {
               Integer actual = Integer.parseInt(content);
               Integer expected = 1;
               assertEquals(expected, actual);

          } catch (Exception e) {
               System.out.println("Could not parse int -> " + e);
          }

     }

     @Test
     public void test365DaysInBetween() {

          String startMonth = "1";
          String startDay = "1";
          String endMonth = "12";
          String endDay = "31";
          String[] input = { startMonth, startDay, endMonth, endDay };

          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          System.setOut(new PrintStream(baos));

          DatesImprove.main(input);
          String output = baos.toString();

          String[] contents = output.split("\n");
          String content = contents[contents.length - 1];
          try {
               Integer actual = Integer.parseInt(content);
               Integer expected = 364;
               assertEquals(expected, actual);

          } catch (Exception e) {
               System.out.println("Could not parse int -> " + e);
          }

     }

}
