package com.tyler.main;

public class Main {

    public static void main(String[] args) {

        int temp, temp2;
        int[] intArray = new int[]{
                90,106,151,205,134,
                55,157,47,149,82,
                35,7,16,62,42,
                152,68,8,146,228,
                253,133,32,178,72
        };

        int[] intArrayIndicies = new int[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            intArrayIndicies[i] = i;
        }

        /** Output all indicies in intArray such that the value for the
         * smallest is first and the next smallest is second etc. **/

        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] > intArray[j]) {
                    temp = intArray[i];
                    temp2 = intArrayIndicies[i];

                    intArray[i] = intArray[j];
                    intArrayIndicies[i] = intArrayIndicies[j];

                    intArray[j] = temp;
                    intArrayIndicies[j] = temp2;
                }
            }
        }

        for (int i = 0; i < intArray.length - 1; i++) {
            System.out.print(intArrayIndicies[i] + ", ");
        }
        System.out.print(intArrayIndicies[intArray.length - 1]);

    }
}
