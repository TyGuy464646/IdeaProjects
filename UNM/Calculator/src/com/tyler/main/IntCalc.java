package com.tyler.main;

/**
 * Made by Tyler Eldred
 * intA takes in the first argument and is the first variable in a simple math equation
 * op takes in the second argument which is the operator in a simple math equation
 * intB takes in the third argument and is the second and final variable in a simple math equation
 *
 * This class is used for simple math equations like adding/subtracting/multiplying/dividing. It is an
 * integer calculator.
 */

public class IntCalc {

    public static int intA;
    public static int intB;
    public static String op;

    public static void main(String[] args) {

        try {
            intA = Integer.parseInt(args[0]);
            op = args[1];
            intB = Integer.parseInt(args[2]);
        } catch (Exception e) {
            usage();
        }

        if (isOp(op)) {
            switch (op) {
                case "+":
                    System.out.println(AddNumbers(intA, intB));
                    break;
                case "-":
                    System.out.println(SubNumbers(intA, intB));
                    break;
                case "*":
                    System.out.println(MultNumbers(intA, intB));
                    break;
                case "/":
                    System.out.println(DivideNumbers(intA, intB));
                    break;
                default:
                    usage();
                    break;
            }
        }
    }

    public static boolean isOp(String operator) {
        boolean validOp;
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")) {
            validOp = true;
        } else {
            validOp = false;
            usage();
        }
        return validOp;
    }

    public static void usage() {
        System.err.println("You have entered too few/many arguments or an invalid operator. The correct input argument usage is:\n" +
                "  IntCalc intA op intB\n" +
                "  intA - an integer value\n" +
                "  intB - an integer value\n" +
                "  op - one of the following arithmetic operations +, -, x, /\n" +
                "  IntCalc performs the arithmetic operation intA op intB and \n" +
                "  prints the results");
    }

    public static int AddNumbers(int A, int B) {
        return A + B;
    }

    public static int SubNumbers(int A, int B) {
        return A - B;
    }

    public static int MultNumbers(int A, int B) {
        return A * B;
    }

    public static int DivideNumbers(int A, int B) {
        return A / B;
    }

}
