package com.sam09.Exercises.bitwiseops;

import java.util.Arrays;

/**
 * @author Soumyabrata09
 */
public enum BitwiseOperands {
    AND("performAND"),
    OR("performOR"),
    XOR("performXOR");
    private String methodName;
    BitwiseOperands(String value) {
        this.methodName = value;
    }

    /**
     *
     * @return methodName as String
     */
    private String getMethodName() {
        return methodName;
    }

    /**
     *
     * @param ope takes the String input
     * @return String value
     */
    private static String checkValidityAndGetMethod(String ope) {
        return Arrays.stream(values())
                .filter(e -> e.name().equals(ope.toUpperCase()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No such operation " + ope + " found\n"))
                .getMethodName();
    }

    /*AND, OR, XOR;*/

    /**
     * This method is the only accessible method of this Enum class
     * @param operation takes string input
     * @return string value
     */
    public static String getBitwiseMethod(String operation) {
        return checkValidityAndGetMethod(operation);
    }
}
