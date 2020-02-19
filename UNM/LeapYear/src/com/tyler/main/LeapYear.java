package com.tyler.main;

public class LeapYear {

    public static void main(String[] args) {
        int inputYear = Integer.parseInt(args[0]);
        boolean isLeapYear = false;

        if (inputYear % 4 == 0) {
            if (inputYear % 100 == 0) {
                if (inputYear % 400 == 0)
                    isLeapYear = true;
                else
                    isLeapYear = false;
            }
            else
                isLeapYear = true;
        }
        else
            isLeapYear = false;

        if(isLeapYear)
            System.out.println("The input year, " + inputYear + ", IS a Leap Year.");
        else
            System.out.println("The input year, " + inputYear + ", is NOT a Leap Year.");
    }

}
