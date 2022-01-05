package com.sam09.Exercises.bitwiseops;

import java.util.Scanner;

/**
 * @author Soumyabrata09
 * This fragemant of code demonstrate how java calculates hash for hash based collections such as HashTable,HashSet,HashMap etc.
 */
public class HashingDemo {
    private static String getBinary(int hashCode) {
        return Integer.toBinaryString(hashCode);
    }

    public static void main(String[] args) {
        System.out.println("Enter a data to calculate the hash: ");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int hashCode = value.hashCode();
        System.out.println("Hashcode generated for " + value +": " + hashCode);
        System.out.println("Binary representation of Hashcode generated for " + value +": " + getBinary(hashCode));
        int unsignedRightShiftVal = hashCode >>> 16;
        System.out.println("UnsignedRightShiftVal: " + unsignedRightShiftVal + " & Binary Rep. " + getBinary(unsignedRightShiftVal));
        int hash = hashCode ^ (hashCode >>> 16);
        System.out.println("Hash Value: " + hash);
        System.out.println("Binary representation of Hash Value: " + hash + ": " + getBinary(hash));
        int bucket = (16-1) & hash;
        System.out.println("Bucket acquired: " + bucket);
        System.out.println("Binary Rep. of Bucket acquired: " + getBinary(bucket));
    }
}
