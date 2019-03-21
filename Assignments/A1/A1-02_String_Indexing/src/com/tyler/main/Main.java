package com.tyler.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int numberChoice;
	    int position;
	    String string;
	    char answer;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a Number!");
        numberChoice = userInput.nextInt();

        System.out.println("Enter a Position within your number in which you want to print out!");
        position = userInput.nextInt();

        string = Integer.toString(numberChoice);
        answer = string.charAt(position-1);

        System.out.println("The number in position " + position + " of your number " + numberChoice + " is " + answer + ".");
    }
}
