package com.sam09.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramDemo {

    public static boolean isAnagramByStream(String input1, String input2) {

        if (input1.length() != input1.length()) {
            return false;
        }
        else {
            char[] inputArray1 = input1.toCharArray();
            char[] inputArray2 = input1.toCharArray();
            Arrays.sort(inputArray1);
            Arrays.sort(inputArray2);
            System.out.println(String.valueOf(inputArray1));
            System.out.println(String.valueOf(inputArray2));
            if (String.valueOf(inputArray1).equals(String.valueOf(inputArray2))) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean isAnagramUsingMap(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }
        else {
            Set<Map.Entry<String, Integer>> inputMap1 = input1.chars()
                    .mapToObj(charItem -> Character.valueOf((char) charItem))
                    .collect(Collectors.toMap(
                            keyMapper -> keyMapper.toString(),
                            valueMapper -> 1,
                            Integer::sum,
                            LinkedHashMap::new
                    )).entrySet();


            Set<Map.Entry<String,Integer>> inputMap2 = input2.chars()
                    .mapToObj(charItem -> Character.valueOf((char) charItem))
                    .collect(Collectors.toMap(
                            keyMapper -> keyMapper.toString(),
                            valueMapper -> 1,
                            Integer::sum,
                            LinkedHashMap::new
                    )).entrySet();

            inputMap1.forEach(writer -> System.out.print("[" + writer.getKey() + " - " + writer.getValue() + "]"));
            System.out.println();
            inputMap2.forEach(writer -> System.out.print("[" + writer.getKey() + " - " + writer.getValue() + "]"));

            if (inputMap1.equals(inputMap2)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static void main(String ar[]) {
        //eat and tea or abbccc and cbacbc
        String str1 = "abbccc";
        String str2 = "cbacbc";

        System.out.println("Are given strings Anagram?<isAnagramByStream> " + AnagramDemo.isAnagramByStream(str1,str2));
        System.out.println("\nAre given strings Anagram?<isAnagramUsingMap> " + AnagramDemo.isAnagramUsingMap(str1,str2));
    }
}
