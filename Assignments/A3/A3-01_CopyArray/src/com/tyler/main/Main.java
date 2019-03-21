package com.tyler.main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /** primitive variables can be copied by assignment.
         * Changes to intB do not affect intA **/
        int intA = 4;
        int intB = intA;
        intB++;
        System.out.println("intA = " + intA);
        System.out.println("intB = " + intB);

        /** The same does not work with objects such as Arrays.
         * rewrite the below so that arrayB starts as a copy of arrayA,
         * and changes to arrayB do not change arrayA **/
        int[] arrayA = {22, -3, 5, 7};
        int[] arrayB = Arrays.copyOf(arrayA, arrayA.length);

        arrayB[2] = 0;

        /** output, do not modify. **/
        System.out.print("\narrayA =");
        for(int i = 0; i < arrayA.length; i++){
            System.out.print(" " + arrayA[i]);
        }
        System.out.print("\narrayB =");
        for(int i = 0; i < arrayB.length; i++){
            System.out.print(" " + arrayB[i]);
        }
        System.out.print("\n");

    }
}
