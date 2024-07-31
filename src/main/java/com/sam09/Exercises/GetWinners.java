package com.sam09.Exercises;

import com.sun.source.doctree.SeeTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * There are N number of friends, and they are all playing a game against each others.
 * initially they all have some energy given energy[i]. Each minutes a game between any two of Bobby's friends occurs.
 * When two friends with equal energy plays then nobody winds the game.
 * When two friends of different energies play, the one with higher initial energy winds the game.
 *
 * Calculate the number of friends who are likely to have the possibilities of winning the game.
 * Note: Some of the friends may have same energy
 *
 * Sample Input::
 *  N (Number of friends) -> 6
 *  energy[i] -> [5, 2, 2, 3, 6, 6]
 *  Output -> 4
 * Explanation:
 *  For some ith friends if no other friends has a smaller energy than them, they cannot win ny game and are not possible winners.
 *  Otherwise, the ith friend is a possible winner.
 *  So, two of the friends have a minimum energy of 2 (as per the given sample input) hence, they cannot win any game.
 *  The other friends have possibility of winning of at least one game.
 *  The total number of friends who can win the game 6 - 2 = 4 therefore, answer will be 4
 */
public class GetWinners {

    private static final Logger logger = LoggerFactory.getLogger(GetWinners.class);

    public static int getWinners(int N, int[] energies) {
        int minEnergy = Arrays.stream(energies).min().getAsInt();
        long minimumEnergyCount = Arrays.stream(energies).filter(ex -> ex == minEnergy).count();
        return N - (int) minimumEnergyCount;
    }

    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of friends: ");
        int friends = scanner.nextInt();
        int[] energies = new int[friends];
        System.out.println(String.format("Enter %d size of energies[int]: \t", friends));
        /*for (int i = 0; i < energies.length; i++) {
            energies[i] = scanner.nextInt();
        }*/
        Arrays.setAll(energies, i -> scanner.nextInt());
        logger.info(String.format("Possible winners of the game: %d", GetWinners.getWinners(friends, energies)));
    }
}
