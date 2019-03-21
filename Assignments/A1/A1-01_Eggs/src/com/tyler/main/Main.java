package com.tyler.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int numOfEggs;
	    int gross;
	    int grossLeftOver;
	    int dozen;
	    int single;

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter a quantity of Eggs!");
        numOfEggs = userInput.nextInt();

        gross = numOfEggs / 144;
        grossLeftOver = numOfEggs % 144;

        dozen = grossLeftOver / 12;
        single = grossLeftOver % 12;

        System.out.println(numOfEggs + " eggs is " + gross + " gross, " + dozen + " dozen, and " + single + " single eggs.");
    }
}
