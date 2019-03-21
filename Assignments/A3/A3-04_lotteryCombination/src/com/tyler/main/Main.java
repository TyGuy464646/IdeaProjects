package com.tyler.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> theList = new ArrayList<>();
        int numPicks = 6;
        int[] lotteryOutput = new int[numPicks];
        Random random = new Random();

        for (int i = 1; i < 50; i++) {
            theList.add(i);
        }

        for (int z = 0; z < numPicks; z++) {
            int index = random.nextInt(theList.size());

            lotteryOutput[z] = theList.get(index);
            theList.remove(index);

        }

        Arrays.sort(lotteryOutput);

        for (int i : lotteryOutput) {
            System.out.println(i);
        }

    }
}
