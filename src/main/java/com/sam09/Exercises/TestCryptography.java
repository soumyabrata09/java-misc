package com.sam09.Exercises;

import com.sam09.cryptography.Base64;
import com.sam09.logging.Loggable;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

@Loggable
public class TestCryptography {

    public static void main(String arg[]) throws UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String encrypt = ");
        String input = scanner.nextLine();
        Base64 base64 = new Base64();
        String encodedString = base64.encode(input.getBytes());
        System.out.println(" encoded string = " + encodedString);
        System.out.println(" decoded string = " + new String(base64.decode(encodedString)));
    }
}
