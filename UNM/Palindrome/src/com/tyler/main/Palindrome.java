package com.tyler.main;

public class Palindrome {

    public static void main(String[] args) {
        String input = args[0];

        checkIfPalindrome(input);
    }

    public static void checkIfPalindrome(String input) {
        String reverseInput = new StringBuffer(input).reverse().toString();

        if (input.equals(reverseInput))
            System.out.println("Yes, the input IS a Palindrome.");
        else
            System.out.println("No, the input is NOT a Palindrome.");
    }

}