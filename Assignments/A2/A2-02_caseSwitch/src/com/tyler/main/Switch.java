package com.tyler.main;

import java.util.Scanner;

public class Switch {

    public static void main(String args[]) {

        int input;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a number 1 through 12");
        input = userInput.nextInt();

        switch(input) {
            case 1:
                System.out.println("Month " + input + " is January which has 31 days.");
                break;
            case 2:
                System.out.println("Month " + input + " is February which has 28 days.");
                break;
            case 3:
                System.out.println("Month " + input + " is March which has 31 days.");
                break;
            case 4:
                System.out.println("Month " + input + " is April which has 30 days.");
                break;
            case 5:
                System.out.println("Month " + input + " is May which has 31 days.");
                break;
            case 6:
                System.out.println("Month " + input + " is June which has 30 days.");
                break;
            case 7:
                System.out.println("Month " + input + " is July which has 31 days.");
                break;
            case 8:
                System.out.println("Month " + input + " is August which has 31 days.");
                break;
            case 9:
                System.out.println("Month " + input + " is September which has 30 days.");
                break;
            case 10:
                System.out.println("Month " + input + " is October which has 31 days.");
                break;
            case 11:
                System.out.println("Month " + input + " is November which has 30 days.");
                break;
            default:
                System.out.println("Month " + input + " is December which has 31 days.");
                break;
        }

    }

}
