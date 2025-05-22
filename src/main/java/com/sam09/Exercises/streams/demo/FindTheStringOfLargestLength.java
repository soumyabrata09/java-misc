package com.sam09.Exercises.streams.demo;

import java.util.*;

/**
 * @author Soumyabrata09
 *
 * Problem Statement: For a given string value( a sentance), find the longest string name and value whose length is even
 */
public class FindTheStringOfLargestLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Enter the String: ");
        String maxLengthString = "";
        int length = 0;
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), " ");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.length() % 2== 0 && token.length() > length) {
//                map.put(token, token.length());
                length = token.length();
                maxLengthString = token;
            }
        }

        /*Map.Entry<String, Integer> result = map.entrySet().stream().sorted(
                        Collections.reverseOrder(Map.Entry.comparingByValue())
                ).findFirst()
                .get();
        System.out.print("Longest String value: " + result.getKey() + " & Length is: " + result.getValue());*/
        System.out.println("Longest String value: " + maxLengthString + " & Length is: " + length);

    }
}
