package com.lab.lab2;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Dates {
    Dates() {
    }

    public static int daysInMonth(int month) {
        return month != 9 && month != 7 && month != 6 && month != 11 ? 31 : 30;
    }

    public static void main(String[] args) {
        int someMonth = Integer.parseInt(args[0]);
        int someDay = Integer.parseInt(args[1]);
        int laterMonth = Integer.parseInt(args[2]);
        int laterDay = Integer.parseInt(args[3]);
        int someDayInYear = 0;
        int laterDayInYear = 0;

        int aMonth;
        for(aMonth = 1; aMonth < someMonth; ++aMonth) {
            someDayInYear += daysInMonth(aMonth);
        }

        while(aMonth < laterMonth) {
            laterDayInYear += daysInMonth(aMonth);
            ++aMonth;
        }

        int daysBetween = 0;
        System.out.println("The difference in days between " + someMonth + "/" + someDay + " and " + laterMonth + "/" + laterDay + " is: ");
        daysBetween = laterDayInYear - someDayInYear;
        daysBetween = daysBetween + laterDay - someDay;
        System.out.println(daysBetween);
    }
}