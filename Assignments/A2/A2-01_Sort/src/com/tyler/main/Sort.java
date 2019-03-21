package com.tyler.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {

        int firstInput;
        int secondInput;
        int thirdInput;
        int fourthInput;

        List<Integer> theList = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter your first integer in which you would like to sort");
        firstInput = userInput.nextInt();
        theList.add(firstInput);

        System.out.println("Enter your second int");
        secondInput = userInput.nextInt();
        theList.add(secondInput);

        System.out.println("Enter your third int");
        thirdInput = userInput.nextInt();
        theList.add(thirdInput);

        System.out.println("Enter your fourth int");
        fourthInput = userInput.nextInt();
        theList.add(fourthInput);

        for (int i = 0; i < theList.size(); i++) {

            for (int j = theList.size() - 1; j > i; j--) {

                if (theList.get(i) > theList.get(j)) {

                    int temporary = theList.get(i);
                    theList.set(i, theList.get(j));
                    theList.set(j, temporary);

                }

            }
        }

        System.out.println("The Largest value entered is " + theList.get(3) + ", and the smallest is " + + theList.get(0));

        System.out.println("Here is a list of your four numbers in order from smallest to largest:");
        for (int i : theList) {
            System.out.println(i);
        }

    }

}
