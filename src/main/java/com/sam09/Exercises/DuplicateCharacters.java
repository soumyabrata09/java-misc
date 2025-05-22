package com.sam09.Exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DuplicateCharacters {

    private static final Logger log = LoggerFactory.getLogger(DuplicateCharacters.class);

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string value:");
        var input = scanner.nextLine();
        log.info("Duplicate charters are: " + findDuplicateCharacters(input));
        log.info("Duplicate charters are: " + findDuplicateCharactersApproach2(input));
        log.info("Each charters Map: " + findEachCharsOccurrence(input));
        log.info("Each charters Map: " + findEachCharsOccurrenceApproach2(input));
    }

    private static List<String> findDuplicateCharacters(String input) {
        return input.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.toMap(
                        key -> key.toString(),
                        value -> 1,
                        Integer::sum
                )).entrySet()
                .stream()
                .filter(item -> item.getValue() > 1)
                .map(item -> item.getKey())
                .toList();
    }

    private static List<String> findDuplicateCharactersApproach2(String input) {
        return Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(mapItem -> mapItem.getValue() > 1)
                .map(mapKey -> mapKey.getKey())
                .toList();
    }

    private static Map<String, Integer> findEachCharsOccurrence(String input) {
        var str = "";
        str = Arrays.stream(input.split(" ")).reduce(str, String::concat);
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(
                        key -> key.toString(),
                        value -> 1,
                        Integer::sum
                )).entrySet()
                .stream()
                .collect(Collectors.toMap(
                        mapper -> mapper.getKey(),
                        mapper -> mapper.getValue()
                ));
    }

    private static Map<String, Long> findEachCharsOccurrenceApproach2(String input) {
        var str = "";
        str = Arrays.stream(input.split(" ")).reduce(str, String::concat);
        return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        mapper -> mapper.getKey(),
                        mapper -> mapper.getValue()
                ));
    }
}
