package com.sam09.Exercises.streams.demo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Soumyabrata09
 * @version 1.0.0
 * @since 2021
 */
public class StringOperationOnStream {

    /**
     * This method only prints a line separator
     */
    private static void lineSeparator() {
        System.out.println("\n----------------");
    }

    /**
     * This method trims the uneven spaces traditionally
     * @param string
     */
    public void trimWhitespacesTraditionally(String string) {
        String resultantString = "";

        for (int index = 0; index < string.length(); index++) {
            if (!Character.isWhitespace(string.charAt(index))) {
                resultantString += string.charAt(index);
            }
            /*if (string.charAt(index) != ' ') {
                resultantString += string.charAt(index);
            }*/
        }
        System.out.print("Result of trimWhitespacesTraditionally(): " + resultantString);
    }

    /**
     * This method trims uneven the whitespaces with StringTokenizer
     * @param string
     */
    public String  trimWhitespacesWithTokenizer(String string) {

        String resultantString = "";
        StringTokenizer tokenizer = new StringTokenizer(string, " ");
        while (tokenizer.hasMoreTokens()) {
            resultantString += tokenizer.nextToken();
        }
        System.out.print("Result of trimWhitespacesWithTokenizer(): " + resultantString);
        return Optional.ofNullable(resultantString)
                .orElseThrow(NullPointerException::new);
    }

    /**
     * This method trims the uneven whitespaces using Java stream()
     * @param string
     */
    public void  trimWhitespacesWithStream(String string) {
        System.out.print("Result of trimWhitespacesWithStream(): ");
        string.chars()
                .mapToObj(character -> Character.valueOf((char) character))
                .forEach(item -> {
                    if (!Character.isWhitespace(item)) {
                        System.out.print(item);
                    }
                });
    }

    public Set<Map.Entry<String,Integer>> countOccurrencesOfCharacters(String string) {
        String trimmedString = trimWhitespacesWithTokenizer(string);
        System.out.println();

         Set<Map.Entry<String,Integer>> characterOccurrencesSet = trimmedString.chars()
                .mapToObj(charItem -> Character.valueOf((char) charItem))
                .collect(Collectors.toMap(
                        key -> key.toString(),
                        value -> 1,
                        Integer::sum
                )).entrySet();

         return Optional.ofNullable(characterOccurrencesSet)
                 .orElseThrow(NullPointerException::new);
    }

    public static void main(String args[]) {
        String str = "I am  a java developer    having 6.2 years of      total    experience";
        StringOperationOnStream object = new StringOperationOnStream();
        object.trimWhitespacesWithStream(str);
        lineSeparator();
        object.trimWhitespacesTraditionally(str);
        lineSeparator();
        object.trimWhitespacesWithTokenizer(str);
        lineSeparator();
        object.countOccurrencesOfCharacters(str).forEach(entry -> {
            System.out.print(entry.getKey() + " appeared: " + entry.getValue() + " times\n");
        });

        List<Map<String, String>> listOfMap = new ArrayList<>();
        List<Map<String,String>> resultantList = new ArrayList<>();

        Map<String,String> map1 = new LinkedHashMap<>();
        map1.put("ID", "001");
        map1.put("Name", "Shyam");
        map1.put("Salary", "50000");

        Map<String,String> map2 = new LinkedHashMap<>();
        map2.put("ID", "002");
        map2.put("Name", "Ram");
        map2.put("Salary", "30000");

        Map<String,String> map3 = new LinkedHashMap<>();
        map3.put("ID", "003");
        map3.put("Name", "Amar");
        map3.put("Salary", "75000");

        Map<String,String> map4 = new LinkedHashMap<>();
        map4.put("ID", "004");
        map4.put("Name", "Akbar");
        map4.put("Salary", "40000");

        Map<String,String> map5 = new LinkedHashMap<>();
        map5.put("ID", "005");
        map5.put("Name", "Joel");
        map5.put("Salary", "90000");

        listOfMap.add(map1);
        listOfMap.add(map2);
        listOfMap.add(map3);
        listOfMap.add(map4);
        listOfMap.add(map5);

        for(Map<String,String> mapObj : listOfMap) {
            System.out.println(mapObj);
        }

        List<String> dummyList = new ArrayList<>();
        dummyList.add("Sam");
        dummyList.add("Dam");
        dummyList.add("Pam");
        dummyList.add("Bam");

        for (Map<String,String> mapObj : listOfMap) {
            System.out.println(mapObj);
            if (Integer.parseInt(mapObj.get("Salary")) >= 50000) {
                resultantList.add(mapObj);
            }
        }
        System.out.println(resultantList);

        System.out.println("Using the Stream()");

        listOfMap.stream()
                .filter(item -> Integer.parseInt(item.get("Salary")) >= 50000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        listOfMap.stream()
                .filter(item -> Integer.parseInt(item.get("Salary")) >= 50000)
                .forEach(e -> System.out.println("Name of the Employee: " + e.get("Name")));

        listOfMap.stream()
                .filter(itm -> Integer.parseInt(itm.get("Salary")) >= 50000)
                .map(elm -> Integer.parseInt(elm.get("Salary")))
                .forEachOrdered(itm -> System.out.println("Salary Amount: " + itm));

        long counter = listOfMap.stream()
                .filter(item -> Integer.parseInt(item.get("Salary")) >= 50000).count();

        System.out.println("Total number of Employees earning more than or equal to 50K: " + Math.toIntExact(counter));

    }
}
