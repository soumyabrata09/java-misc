package com.sam09.Exercises;

import com.sam09.misc.utils.StringUtilities;

import java.util.*;
import java.util.stream.Collectors;

public class AnagramDemo {

    public static boolean isAnagramByStream(String input1, String input2) {

        if (input1.length() != input2.length()) {
            return false;
        }
        else {
            char[] inputArray1 = input1.toLowerCase().toCharArray();
            char[] inputArray2 = input2.toLowerCase().toCharArray();
            Arrays.sort(inputArray1);
            Arrays.sort(inputArray2);
            System.out.println(String.valueOf(inputArray1));
            System.out.println(String.valueOf(inputArray2));
            if (String.valueOf(inputArray1).equalsIgnoreCase(String.valueOf(inputArray2))) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static Set<Map.Entry<String, Integer>> getOccurrencesOfCharsEntrySet(String strParam) {
        return strParam.chars()
                .mapToObj( item -> Character.valueOf((char) item))
                .collect(Collectors.toMap(
                        keyMapper -> keyMapper.toString().toLowerCase(),
                        valueMapper -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                )).entrySet();

    }

    public static boolean isAnagramUsingMap(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }
        else {
            Set<Map.Entry<String, Integer>> inputMap1 = getOccurrencesOfCharsEntrySet(input1);
            Set<Map.Entry<String,Integer>> inputMap2 = getOccurrencesOfCharsEntrySet(input2);

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
        String str1 = "abbcccXx";
        String str2 = "cXbacbcX";

        System.out.println("Are given strings Anagram?<isAnagramByStream> " + AnagramDemo.isAnagramByStream(str1,str2));
        System.out.println("\nAre given strings Anagram?<isAnagramUsingMap> " + AnagramDemo.isAnagramUsingMap(str1,str2));
        System.out.printf("Given Strings %s and %s are anagram? %b", str1,str2, StringUtilities.isAnagram(str1,str2) );
    }
}
