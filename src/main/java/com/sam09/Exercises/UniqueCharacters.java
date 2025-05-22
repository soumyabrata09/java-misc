package com.sam09.Exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author soumyabrata
 */
public class UniqueCharacters {

    private static final Logger logger = LoggerFactory.getLogger(UniqueCharacters.class);

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string value: ");
        var input = scanner.nextLine();
        logger.info("Unique Characters " + findUniqueCharacter(input));
    }

    private static List<String> findUniqueCharacter(String input) {
        var str = "";
        str = Arrays.stream(input.split(" ")).reduce(str, String::concat);
        return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(unique -> unique.getValue() == 1)
                .map(unique -> unique.getKey())
                .toList();
    }

}
