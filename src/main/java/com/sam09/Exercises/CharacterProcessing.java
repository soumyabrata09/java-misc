package com.sam09.Exercises;

/**
 * @author Soumyabrata09
 *
 * Given a string "abcdaghj".
 * Process this char by char and print a msg "already processed" when it's not the first time you find this char.
 */
public class CharacterProcessing {
    public static void main(String[] args) {
        String input = "abcdaghj";
        char characterList[] = input.toCharArray();
        boolean isProcessed;
        for (int i = 0; i < characterList.length; i++) {
            isProcessed = false;
            for (int j = i; j < characterList.length; j++) {

                if (characterList[i] == characterList[j] && i != input.indexOf(characterList[j])) {
                    isProcessed = true;
                    System.out.println(
                            "Already processed " + characterList[i] + " index :" + i + " first index :" + input.indexOf(characterList[j]));
                }
            }
            if (!isProcessed) {
                System.out.println("Processing " + characterList[i] + " first index :" + input.indexOf(characterList[i]));
            }
        }
    }
}
