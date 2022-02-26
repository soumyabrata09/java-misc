package com.sam09.Exercises;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Soumyabrata09
 *
 * Find the farthest number from 0
 * int[] array = int[] array = new int[]{1, 4, -2, 5, -5, 3 , -1};
 *
 *
 * {1, 4, -2, -5, 7, 3 , -1} output: 7
 *
 * {1, 4, -2, -8, -5, 3 , -1} output: -8
 *
 * {1, 4, -2, 5, -5, 3 , -1} output: -5
 */
public class FarthestNumberFromZero {

    public static int[] getIntArray(Scanner scanner, int range){
        return Optional.ofNullable(
                IntStream.range(0, range)
                        .boxed()
                        .mapToInt( item -> scanner.nextInt())
                        .toArray())
                .orElseGet(() -> new int[range]);
    }

    public static int getFarthestNumber(int[] array) {
        int distance = 0;
        int minimumDistance =0;
        for (int index = 0; index < array.length; index++) {
            if ( Math.abs(array[index]) > Math.abs(distance) ){
                distance = array[index];
            }
            if ( Math.abs(array[index]) == Math.abs(distance) ) {
                if ( array[index] > distance) {
                    minimumDistance = distance;
                }
                else {
                   minimumDistance = array[index];
                }
            }

        }
        return (minimumDistance == 0 ? distance : minimumDistance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array range: ");
        int range = scanner.nextInt();
        System.out.println("Enter random (int) values[combination of -ve && +ve]: ");

        int[] generatedArray = FarthestNumberFromZero.getIntArray(scanner, range);
        int farthestElement =0;

        boolean notNull = Arrays.stream(generatedArray).allMatch(Objects::nonNull); // checking whether the generatedArray is initialized
        if (notNull) {
            farthestElement = FarthestNumberFromZero.getFarthestNumber(generatedArray);
            System.out.println("Farthest Element from Zero: " + farthestElement);
        }
        else {
            throw new RuntimeException("Array not initialized");
        }
    }
}
