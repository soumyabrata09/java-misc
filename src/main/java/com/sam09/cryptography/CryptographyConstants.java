package com.sam09.cryptography;

public class CryptographyConstants {
    public static final int BASE = 64;
    private static String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    private static String DIGITS = "0123456789";
    private static String SPECIAL_CHARACTER = "+-";
    public static final String STANDARD_ALPHABET = ALPHABETS.toUpperCase() + ALPHABETS + DIGITS +SPECIAL_CHARACTER;
}
