package com.sam09.misc.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayUtility {
    private static final int startIndex = 0;
    public static int[] createArray(Scanner scanner, int range) {
        int[] array = IntStream.range(startIndex, range)
                .boxed()
                .mapToInt(item -> scanner.nextInt())
                .toArray();
        int[] optionalIntegerArray = Optional.ofNullable(array).orElseGet(() -> new int[range]);

        return optionalIntegerArray;
    }

    public static boolean hasArrayInitialized(int[] array) {
        boolean flag = Arrays.stream(array).allMatch(Objects::nonNull);

        return flag;
    }
}
