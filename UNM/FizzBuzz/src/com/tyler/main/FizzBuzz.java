package com.tyler.main;

/**
 * Made by Tyler Eldred
 * Fizz takes in the first argument, and any number divisible by it will return "Fizz" in the command line.
 * Buzz takes in the second argument, and any number divisible by it will return "Buzz" in the command line.
 * upperLimit takes in the third argument, and it sets the limit at which the program counts to.
 *
 * This class is used for distinguishing variables that are divisible by Fizz, Buzz, and both.
 */

public class FizzBuzz {

    public static void main(String[] args) {

        int fizz = Integer.parseInt(args[0]);
        int buzz = Integer.parseInt(args[1]);
        int upperLimit = Integer.parseInt(args[2]);

//        int fizz = 5;
//        int buzz = 7;
//        int upperLimit = 100;

        for (int i = 1; i < upperLimit + 1; i++) {
            if (i % fizz == 0 && i % buzz == 0) {
                System.out.println("Fizz Buzz");
            }

            else if (i % fizz == 0) {
                System.out.println("Fizz");
            }

            else if (i % buzz == 0) {
                System.out.println("Buzz");
            }

            else {
                System.out.println(i);
            }
        }
    }

}
