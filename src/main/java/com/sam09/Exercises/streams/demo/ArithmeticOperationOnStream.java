package com.sam09.Exercises.streams.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Soumyabrata09
 * @version 1.0.0
 * @since 2021
 */
public class ArithmeticOperationOnStream {

    private static final Logger log = LoggerFactory.getLogger(ArithmeticOperationOnStream.class);
    private static final int DEFAULT_LIMIT = 15;

    /**
     * This method only prints a line separator
     */
    private static void lineSeparator() {
        System.out.println("\n----------------");
    }

    /**
     * This method prints an array of integer with random values upto the limit provided at the time of method call
     * @param limit of type int
     * @return an array of int[]
     */
    private static int[] generateRandomArray(int limit) {
        final int startIndex = 0;
        int[] sampleArray = new int[limit];
        int bound = 20;
        Random random = new Random();

        /*IntStream.range(startIndex,limit).boxed()
                .forEach( value -> {
                    sampleArray[value] = (int) Math.abs(random.nextGaussian());
                });*/
        IntStream.range(startIndex, limit)
                        .forEach(value -> {
                            int positiveRandomValue = Math.abs(random.nextInt(bound));
                            sampleArray[value] = positiveRandomValue;
                        });
        return sampleArray;
    }

    /**
     * This method prints an array element using streams
     * @param array
     */
    private static void printArrayElement(int[] array) {
        log.info("::Array Elements[Using Method reference]::\n");
        Arrays.stream(array).forEach(System.out :: print);
        lineSeparator();
        log.info("::Array Elements[Using Lambda expression]::\n");
        Arrays.stream(array).forEach(element -> System.out.print(element + "\t"));
        lineSeparator();
    }

    /**
     * This method converts int[] to Integer[]
     * @param array
     * @return returns an array of Integer
     * @throws CustomArrayConversionException
     */
    private static Integer[] convertToIntegerWrapper(int[] array){
        log.info("Converting int[] to Integer[] by explicitly setting each value while in iteration\n");
        Integer[] arrayInteger = new Integer[array.length];
        Arrays.setAll(arrayInteger, arrElement -> array[arrElement]);

        return Optional.ofNullable(arrayInteger)
                .orElseThrow(() -> new CustomArrayConversionException("Can not convert int[] to Integer[]"));
    }

    /**
     * This method converts int[] to Integer[] using autoboxing
     * @param array
     * @return returns an array of Integer
     * @throws CustomArrayConversionException
     */
    private static Integer[] convertToBoxedArrayInteger(int[] array) {
        log.info("Converting int[] to Integer[] using Boxing \n");
        Integer[] arrayIntegerWrapper = Arrays.stream(array).boxed().toArray(Integer[] :: new);

        return Optional.ofNullable(arrayIntegerWrapper)
                .orElseThrow(() -> new CustomArrayConversionException("Can not convert int[] to Integer[]"));
    }

    /**
     * This method converts int[] into List of type Integer using autoboxing
     * @param array
     * @return returns List of Integer
     * @throws CustomArrayConversionException
     */
    private static List<Integer> convertBoxedListOfInteger(int[] array) {
        log.info("Converting int[] to Integer[] using Boxing \n");
        List<Integer> element = IntStream.of(array).boxed().collect(Collectors.toList());

        return Optional.ofNullable(element)
                .orElseThrow(() -> new CustomArrayConversionException("Can not convert int[] to Integer[]"));
    }

    /**
     * This method calculates the total number of elements
     * @param array
     * @return counter value of number of array elements
     * @throws NullPointerException
     */
    public static int getCountOfElements(int[] array) {
       int count = Math.toIntExact(
               Arrays.stream(array)
                       .boxed()
                       .count());

       return Optional.ofNullable(count)
               .orElseThrow(NullPointerException::new);
    }

    /**
     * This method counts the distinct items of the array
     * @param array
     * @return distinct count of array element
     * @throws NullPointerException
     */
    public static int getDistinctElement(int[] array) {
        int distinct = Math.toIntExact(
                Arrays.stream(array)
                        .boxed()
                        .distinct()
                        .count());

        return Optional.ofNullable(distinct)
                .orElseThrow(NullPointerException::new);
    }

    /**
     * This method count the occurrences of each element in an array and prints them
     * @param array
     */
    public static void printOccurrenceOfArrayItems(int[] array) {
        IntStream.of(array)
                .boxed()
                .collect(Collectors.toMap(
                        key -> key,
                        value -> 1,
                        Integer::sum
                )).entrySet()
                .forEach(entry -> System.out.println(entry.getKey() + " appeared: " + entry.getValue() + " times"));
    }

    public static void main(String arg[]) {
        //int[] sampleArray = new int[]{2, 4, 5, 1, 3, 9, 2, 5, 1, 4, 1, 9, 12, 2, 3, 2};
        System.out.println("Enter a limit to generate an array of int with random values (positive): ");
        int input = Optional.ofNullable(new Scanner(System.in).nextInt()).orElse(DEFAULT_LIMIT);
        int[] sampleArray = ArithmeticOperationOnStream.generateRandomArray(input);

        ArithmeticOperationOnStream.printArrayElement(sampleArray);
        //log.info("Total number of array Element: " + ArithmeticOperationOnStream.getCountOfElements(sampleArray));
        System.out.print("Total number of array Element: " + ArithmeticOperationOnStream.getCountOfElements(sampleArray));
        lineSeparator();
        //log.info("Total number of distinct array Element: " + ArithmeticOperationOnStream.getDistinctElement(sampleArray));
        System.out.print("Total number of distinct array Element: " + ArithmeticOperationOnStream.getDistinctElement(sampleArray));
        lineSeparator();
        ArithmeticOperationOnStream.printOccurrenceOfArrayItems(sampleArray);
        lineSeparator();
        int minimum = Arrays.stream(sampleArray).min().getAsInt();
        int maximum = Arrays.stream(sampleArray).max().getAsInt();
        System.out.println("Maximum: " + maximum);
        System.out.println("Minimum: " + minimum);
        System.out.println("Difference (max,min): " + Math.subtractExact(maximum,minimum));

        List<Integer> intList = Arrays.asList(2, 4, 5, 1, 3, 9, 2, 5, 1, 4, 1, 9, 12, 2, 3, 2);
        intList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(item -> System.out.print(item + "\t"));
        lineSeparator();

        //remove duplicate values from the sample arrayList
        intList.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .forEach(item -> System.out.print(item + "\t"));
        lineSeparator();
        //remove duplicate values from the sample arrayList and sort it
        intList.stream()
                .collect(Collectors.toCollection(TreeSet::new))
                .forEach(item -> System.out.print(item + "\t"));
        lineSeparator();
        //remove duplicate values from the sample arrayList and sort it in descending order
        intList.stream()
                .collect(Collectors.toCollection(TreeSet::new))
                .descendingSet()
                .forEach(item -> System.out.print(item + "\t"));

        /*
        * For a given List of Integers, find the summation of squared odd values from the list
        * */

        int sumOfSquareOnFilteredData = intList.stream()
                .filter(item -> item % 2 == 1)
                .map(filteredItem -> Math.pow(filteredItem, 2))
                .reduce(0.0, (itm1, itm2) -> itm1 + itm2)
                .intValue();

        Stream<Integer> filteredOddData = intList.stream().filter(item -> item % 2 == 1);

        Stream<Double> oddNumberSquareStream = intList.stream()
                .filter(item -> item % 2 == 1)
                .map(element -> Math.pow(element, 2));
        System.out.print("List of odd values: : ");
        filteredOddData
                .forEach( out -> System.out.print(out + "\t") );
        System.out.print("\nList of squared odd values: ");
        oddNumberSquareStream
                .forEach(out -> System.out.print("\t" + out + "\t") );

        System.out.println("\nSum data of Squared odd data: " + sumOfSquareOnFilteredData);
    }
}
