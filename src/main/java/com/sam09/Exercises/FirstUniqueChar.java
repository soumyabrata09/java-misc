package com.sam09.Exercises;

//First unique character of a string. E.g. aabdccebd . Output : e

import java.util.*;
import java.util.stream.Collectors;

enum CharacterAppearedOperationEnum {
    MAXIMUM, MINIMUM
}

public class FirstUniqueChar {

    public static void getFirstUniqueCharacter(String input) {
        Map<Character,Integer> hashMap = new LinkedHashMap<>();

        for ( int i = 0; i < input.length(); i++) {
            Character localChar = input.charAt(i);
            if (!hashMap.isEmpty()) {
                if (hashMap.get(localChar) == null) {
                    hashMap.put(localChar, 1);
                } else {
                    int appeared = hashMap.get(localChar);
                    hashMap.put(localChar, appeared + 1);
                }
            } else {
                hashMap.put(localChar,1);
            }
        }

        for ( Map.Entry<Character,Integer> elem : hashMap.entrySet()) {
            if (elem.getValue() == 1) {
                System.out.println("First unique: " + elem.getKey());
                break;
            }
        }
    }

    public static Character getFirstUniqueCharacterByStream(String input) {
        Character firstUniqueCharacter = input.chars()
                .mapToObj(characterItem -> Character.valueOf((char) characterItem))
                .collect(Collectors.toMap(
                        keyMapper -> keyMapper.toString(),
                        valueMapper -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                )).entrySet()
                .stream()
                .filter(linkedMapItem -> linkedMapItem.getValue().equals(1))
                .findFirst()
                .get()
                .getKey()
                .charAt(0); // this is converting string into character / char

        return firstUniqueCharacter;
    }

    public static Map<String, Integer> getMaxOrMinAppearedCharacter(String input, CharacterAppearedOperationEnum operationMode) {
        Map<String, Integer> mapObject = input.chars()
                .mapToObj(item -> Character.valueOf((char) item))
                .collect(Collectors.toMap(
                        key -> key.toString(),
                        value -> 1,
                        Integer::sum
                ));


        Map<String, Integer> appearedCharacterMap = null;

        if (operationMode.equals(CharacterAppearedOperationEnum.MAXIMUM)) {
            int maximumMapValue = mapObject.values()
                    .stream()
                    .mapToInt(mapValue -> mapValue)
                    .max()
                    .getAsInt();

            appearedCharacterMap = getMap(mapObject,maximumMapValue);
        }
        else {
            int minimumMapValue = mapObject.values()
                    .stream()
                    .mapToInt(mapValue -> mapValue)
                    .min()
                    .getAsInt();

            appearedCharacterMap = getMap(mapObject,minimumMapValue);
        }

        return Optional.ofNullable(appearedCharacterMap)
                .orElseThrow(NullPointerException::new);
    }

    public static Map<String, Integer> getMap(Map<String,Integer> mapObject, int appearanceValue) {
        return mapObject.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(),appearanceValue))
                .collect(Collectors.toMap(
                        mapper -> mapper.getKey(),
                        mapper -> mapper.getValue()
                ));
    }

    public static void main(String ar[]) {
//        char[] charValue = "aabdccebd".toCharArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String inputValue = scanner.next();
        System.out.println("First Unique Character(using Streams): " + FirstUniqueChar.getFirstUniqueCharacterByStream(inputValue));

        CharacterAppearedOperationEnum OperationMode = CharacterAppearedOperationEnum.MINIMUM;
        System.out.println(OperationMode.equals(CharacterAppearedOperationEnum.MAXIMUM) ?
                (FirstUniqueChar.getMaxOrMinAppearedCharacter(inputValue, CharacterAppearedOperationEnum.MAXIMUM) + " appeared maximum ") :
                (FirstUniqueChar.getMaxOrMinAppearedCharacter(inputValue, CharacterAppearedOperationEnum.MINIMUM) + " appeared minimum "));
    }

}
