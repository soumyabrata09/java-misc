package com.sam09.Exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author soumyabrata
 * Description: If given array of string str1[] = { "follow", "follower", "following" } then output -> "follow"
 * input-2: str2[] = { "play", "plumber", "pluralism", "plagiarism" } then output - "pl"
 */
public class LongestCommonString {

    private static final Logger log = LoggerFactory.getLogger(LongestCommonString.class);

    public static void main(String args[]) {
        String[] str1 = {"follower", "follow", "following"};
        String[] str2 = {"pluralism", "play", "plumber", "plagiarism"};

        log.info("Longest common prefix is str1 -> " + findLongestCommonPrefixApproach1(str1));
        log.info("Longest common prefix is str2 -> " + findLongestCommonPrefixApproach1(str2));
        log.info("=========");
        log.info("Longest common prefix is str1 -> " + findLongestCommonPrefixApproach2(str1));
        log.info("Longest common prefix is str2 -> " + findLongestCommonPrefixApproach2(str2));
        log.info("=========");
        log.info("Longest common prefix is str1 -> " + findLongestCommonPrefixApproach3(str1));
        log.info("Longest common prefix is str2 -> " + findLongestCommonPrefixApproach3(str2));
        log.info("=========");
        log.info("Longest common prefix is str1 -> " + findLongestCommonPrefixApproach4(str1));
        log.info("Longest common prefix is str2 -> " + findLongestCommonPrefixApproach4(str2));
    }

    /**
     * Below approach is the simplest one
     * @param str
     * @return
     */
    private static String findLongestCommonPrefixApproach1(String[] str) {
        if (str == null || str.length == 0) {
            return "";
        }
        var prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**
     * Below approach is a good fit when array size is bigger
     *
     * @param str
     * @return String (Longest common prefix)
     */
    private static String findLongestCommonPrefixApproach2(String[] str) {
        if (str == null || str.length == 0) return "";
        return longestCommonPrefixApproach2(str, 0, str.length - 1);
    }

    private static String longestCommonPrefixApproach2(String[] str, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return str[leftIndex];
        } else {
            var midIndex = (leftIndex + rightIndex) / 2;
            var leftPart = longestCommonPrefixApproach2(str, leftIndex, midIndex);
            var rightPart = longestCommonPrefixApproach2(str, midIndex + 1, rightIndex);
            return commonPrefixPart(leftPart, rightPart);
        }
    }

    private static String commonPrefixPart(String leftPart, String rightPart) {
        var minLength = Math.min(leftPart.length(), rightPart.length());
        for (int i = 0; i < minLength; i++) {
            if (leftPart.charAt(i) != rightPart.charAt(i)) {
                return leftPart.substring(0, i);
            }
        }

        return leftPart.substring(0, minLength);
    }

    /**
     * below approach demonstrates how we can achieve it by sorting
     * @param str
     * @return String (Longest common prefix)
     */
    private static String findLongestCommonPrefixApproach3(String[] str) {
        if (str == null || str.length == 0) return "";
        Arrays.sort(str);
        var firstLetter = str[0];
        var lastLetter = str[str.length - 1];
        var index = 0;

        while (index < firstLetter.length() && index < lastLetter.length() && firstLetter.charAt(
                index) == lastLetter.charAt(index)) {
            index++;
        }
        return firstLetter.substring(0, index);
    }

    /**
     * Below approach demonstrate how we can utilize the regex (it will also ensure case insensitivity)
     * @param str
     * @return String (Longest common prefix)
     */
    private static String findLongestCommonPrefixApproach4(String[] str) {
        if (str == null || str.length == 0) return "";
        var commonPrefix = str[0];
        for (int i = 1; i < str.length; i++) {
            commonPrefix = longestCommonPrefixOfTwoStrings(commonPrefix, str[i]);
            if (commonPrefix.isEmpty()) break;
        }
        return commonPrefix;
    }

    /**
     * This method will find the longest common part of two given strings
     * @param firstStr
     * @param secondStr
     * @return String
     */
    private static String longestCommonPrefixOfTwoStrings(String firstStr, String secondStr) {
        var commonPrefix = "";
        var maxIterableLength = Math.min(firstStr.length(), secondStr.length());
        for (int i = 0; i < maxIterableLength; i++) {
            var prefix = firstStr.substring(0, i + 1);
            var pattern = Pattern.compile("(?i)^".concat(prefix)); // This pattern ensure case-insensitivity
            var firstMatch = pattern.matcher(firstStr);
            var secondMatch = pattern.matcher(secondStr);
            if (firstMatch.find() && secondMatch.find()) {
                commonPrefix = prefix;
            } else {
                break;
            }
        }
        return commonPrefix;
    }

}
