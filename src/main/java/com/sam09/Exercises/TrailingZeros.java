package com.sam09.Exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * <div>
 * <p>
 *  You have an arrays of zeros (0) and (1) keep all zeros at the left hand side and all 1 to right hand side ?
 *  e.g Integer array[] =[1,1,0,1,0] -> output : [0,0,1,1,1]
 * </p>
 * </div>
 * @author soumyabrata
 */
public class TrailingZeros {

    private static final Logger logger = LoggerFactory.getLogger(TrailingZeros.class);

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a binary input sequence: \t");
        var input = scanner.nextLine();
        handleError(input.split(" "));
        logger.info("Trailing Zeros: " + getTrailingZeros(input));
    }

    private static List<Integer> getTrailingZeros(String input) {
        return Arrays.stream(input.split(" "))
                .sorted(Comparator.reverseOrder())
                .mapToInt(elem -> Integer.parseInt(elem))
                .boxed()
                .toList();
    }

    private static void handleError(String[] strings) {
        Arrays.stream(strings)
                .filter(ch -> !ch.matches("\\d+")
                ).findAny()
                .ifPresent(elem -> {
                    throw new IllegalArgumentException(String.format("Non Digit input found %s", elem));
                });
    }
}

