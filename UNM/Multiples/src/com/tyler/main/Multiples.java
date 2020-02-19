package com.tyler.main;

public class Multiples {

    private static int N;

    public static void main(String[] args) {
        N = Integer.parseInt(args[0]);

        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " X " + i + " = " + N*i);
        }
    }

}
