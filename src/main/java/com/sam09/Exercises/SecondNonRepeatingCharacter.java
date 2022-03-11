package com.sam09.Exercises;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SecondNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        getSecondNonRepeatingCharacter(input, 2);
    }

    public static void getSecondNonRepeatingCharacter(String input, int position) {
        String secondNonRepeatingCharacter = input.chars()
                .mapToObj( charItem -> (char) charItem)
                .collect(Collectors.toMap(
                        keyMapper -> keyMapper.toString(),
                        valueMapper -> 1,
                        Integer::sum
                )).entrySet()
                .stream()
                .filter( value -> value.getValue() == 1)
                .map( mapItem -> mapItem.getKey())
                .collect(Collectors.toCollection(ArrayList::new))
                .get(position - 1);

        System.out.println("Second Non Repeating Character: " + secondNonRepeatingCharacter);
    }
}
