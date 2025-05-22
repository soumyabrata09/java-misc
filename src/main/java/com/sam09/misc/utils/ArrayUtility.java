package com.sam09.misc.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArrayUtility {
    private static final int START_INDEX = 0;
    public static int[] createArray(Scanner scanner, int range) {
        int[] array = IntStream.range(START_INDEX, range)
                .boxed()
                .mapToInt(item -> scanner.nextInt())
                .toArray();
        return Optional.ofNullable(array).orElseGet(() -> new int[range]);
    }

    public static boolean hasArrayInitialized(int[] array) {
        return Arrays.stream(array).allMatch(Objects::nonNull);
    }
}
