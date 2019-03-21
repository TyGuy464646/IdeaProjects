package com.tyler.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        float temp;
        float[] arrayList;
        arrayList = new float[25];

        for(int i = 0; i < 25; i++) {
            float rand = (float) Math.random() * 100f;
            arrayList[i] = rand;
        }

        for (int i = 0; i < arrayList.length; i++) {
            for (int j = i + 1; j < arrayList.length; j++) {
                if (arrayList[i] > arrayList[j]) {
                    temp = arrayList[i];
                    arrayList[i] = arrayList[j];
                    arrayList[j] = temp;
                }
            }
        }

        for (int i = 0; i < arrayList.length - 1; i++) {
            System.out.print(arrayList[i] + ", ");
        }
        System.out.print(arrayList[arrayList.length - 1]);

    }
}
