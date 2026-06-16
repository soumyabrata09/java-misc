/**
 * Group Anagrams
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 *
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 * Example 2:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 *
 * Output: [["a"]]
 *
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */

package com.sam09.org.datastructure.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramGroups {

    static final Logger log = LoggerFactory.getLogger(AnagramGroups.class);

    static String computeCharFreqCount(String strVal) {
        var freqCharCounter = new int[26];
        for (var ch : strVal.toCharArray()) {
            freqCharCounter[ch - 'a']++;
        }
        return Arrays.toString(freqCharCounter);
    }

    static List<List<String>> getAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return List.of();
        }
        var freqMap = new HashMap<String, List<String>>();
        for (var strVal : strs) {
            var keyElem = computeCharFreqCount(strVal);
            freqMap.computeIfAbsent(keyElem, k -> new ArrayList<>()).add(strVal);
        }
        return List.copyOf(freqMap.values());
    }

    public static void main (String args[]) {
        var arr = new String[] {"eat","tea","tan","ate","nat","bat"};
        var result = getAnagrams(arr);

        log.info("Anagram  sets: {}", result);
    }

}
