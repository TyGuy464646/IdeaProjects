package com.tyler.main;

import java.util.Scanner;

public class Quadratic {

    public static void main(String args[]) {

        double a;
        double b;
        double c;
        double x1;
        double x2;

        Scanner userInput = new Scanner(System.in);

        System.out.println("This program solves equations of the form a*x^2 + b*x + c = 0. Enter a, b and c.");
        a = userInput.nextDouble();
        b = userInput.nextDouble();
        c = userInput.nextDouble();

        double d = (b*b) - 4 * a * c;

        if (d >= 0) {

            x1 = (-b + Math.sqrt((b*b) - 4 * a * c))/(2*a);
            x2 = (-b - Math.sqrt((b*b) - 4 * a * c))/(2*a);

            System.out.println("Solutions to " + a + "x^2 + " + b + "x + " + c + " = 0 are x = " + x1 + " and x = " + x2 + ".");

        } else {

            x1 = (Math.sqrt(-d)/(2 * a));

            System.out.println("Solutions to " + a + "x^2 + " + b + "x + " + c + " = 0 are x = " + (-b)/(2*a) + " + " + x1 + "i and x = " + (-b)/(2*a) + " - " + x1 + "i.");

        }

    }

}
