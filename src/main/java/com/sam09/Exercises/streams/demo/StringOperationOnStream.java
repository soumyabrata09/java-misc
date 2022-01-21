package com.sam09.Exercises.streams.demo;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @author Soumyabrata09
 * @version 1.0.0
 * @since 2021
 */
public class StringOperationOnStream {

    /**
     * This method only prints a line separator
     */
    private static void lineSeparator() {
        System.out.println("\n----------------");
    }

    /**
     * This method trims the uneven spaces traditionally
     * @param string
     */
    public void trimWhitespacesTraditionally(String string) {
        String resultantString = "";

        for (int index = 0; index < string.length(); index++) {
            if (!Character.isWhitespace(string.charAt(index))) {
                resultantString += string.charAt(index);
            }
            /*if (string.charAt(index) != ' ') {
                resultantString += string.charAt(index);
            }*/
        }
        System.out.print("Result of trimWhitespacesTraditionally(): " + resultantString);
    }

    /**
     * This method trims uneven the whitespaces with StringTokenizer
     * @param string
     */
    public String  trimWhitespacesWithTokenizer(String string) {

        String resultantString = "";
        StringTokenizer tokenizer = new StringTokenizer(string, " ");
        while (tokenizer.hasMoreTokens()) {
            resultantString += tokenizer.nextToken();
        }
        System.out.print("Result of trimWhitespacesWithTokenizer(): " + resultantString);
        return Optional.ofNullable(resultantString)
                .orElseThrow(NullPointerException::new);
    }

    /**
     * This method trims the uneven whitespaces using Java stream()
     * @param string
     */
    public void trimWhitespacesWithStream(String string) {
        System.out.print("Result of trimWhitespacesWithStream(): ");
        string.chars()
                .mapToObj(character -> Character.valueOf((char) character))
                .forEach(item -> {
                    if (!Character.isWhitespace(item)) {
                        System.out.print(item);
                    }
                });
    }

    public Set<Map.Entry<String,Integer>> countOccurrencesOfCharacters(String string) {
        String trimmedString = trimWhitespacesWithTokenizer(string);
        System.out.println();
         Set<Map.Entry<String,Integer>> characterOccurrencesSet = trimmedString.chars()
                .mapToObj(charItem -> Character.valueOf((char) charItem))
                .collect(Collectors.toMap(
                        key -> key.toString(),
                        value -> 1,
                        Integer::sum
                )).entrySet();

         return Optional.ofNullable(characterOccurrencesSet)
                 .orElseThrow(NullPointerException::new);
    }

    public static void main(String args[]) {
        String str = "I am  a java developer    having 6.2 years of      total    experience";
        StringOperationOnStream object = new StringOperationOnStream();
        object.trimWhitespacesWithStream(str);
        lineSeparator();
        object.trimWhitespacesTraditionally(str);
        lineSeparator();
        object.trimWhitespacesWithTokenizer(str);
        lineSeparator();
        object.countOccurrencesOfCharacters(str).forEach(entry -> {
            System.out.print(entry.getKey() + " appeared: " + entry.getValue() + " times\n");
        });
    }
}
