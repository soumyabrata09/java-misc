package com.sam09.misc.utils;

import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringUtilities {
    private static final int START_INDEX = 0;

    public static String reverseUsingStack(String string) {
        StringBuffer reverseString = new StringBuffer();
        Stack<Character> stack = string.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.toCollection(Stack::new));
        while (!stack.isEmpty()) {
            reverseString.append(stack.pop());
        }

        return reverseString.toString();
    }

    public static String reverseString(String string) {
        final int length = string.length();
        return IntStream.range(START_INDEX, length)
                .map( index -> string.charAt( length - 1 - index))
                .collect(StringBuffer::new,
                        ((buffer, value) -> buffer.append((char) value)),
                        StringBuffer::append).toString();
    }

    public static boolean isPalindrome(String string) {
        String reversedString = reverseString(string);
        if (reversedString.equalsIgnoreCase(string)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isAnagram(String stringParam1, String stringParam2) {
        boolean flag;
        if (stringParam1.length() != stringParam2.length()) {
            flag = Boolean.FALSE;
        }
        else {
            Map<String,Integer> map1 = getOccurrencesOfEachChars(stringParam1);
            Map<String,Integer> map2 = getOccurrencesOfEachChars(stringParam2);
            if (map1.equals(map2))
                flag = Boolean.TRUE;
            else
                flag = Boolean.FALSE;
        }

        return flag;
    }

    public static Map<String, Integer> getOccurrencesOfEachChars(String string) {
        return string.chars()
                .mapToObj(item -> Character.valueOf((char) item))
                .collect(Collectors.toMap(
                        key -> key.toString().toLowerCase(),
                        value -> 1,
                        Integer::sum
                ));
    }
}
