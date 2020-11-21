package com.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import com.org.swingComponents.tabbedPaneConstruct;
import com.org.swingComponents.tableConstruct;

/**
 * @author Sam
 *
 */
/*
 * Given a string or array of integers 
 * this program aim is to find out the number of occurrence frequency of each letter/ number 
 * 
 * This program is being implemented in different ways using collection frame into consideration  
 * */
public class wordFrequencyDeterminer {

	/**
	 * @param args for command line argument
	 */
	static JFrame frame ;
	public static void main(String[] args) {
		int[] arr= {10,25,90,76,90,10,8,10,25};
		//the following string uses all the 26 letters of English
		@SuppressWarnings("unused")
		String str_hardCoded="the quick brown fox jumps over the lazy dog";
		System.out.println("Enter a Word = ");
		@SuppressWarnings("resource")
		String str = new Scanner(System.in).nextLine();
		tabbedPaneConstruct tpane = new tabbedPaneConstruct();
		
		 frame = new JFrame();
		 frame.add(tpane.getTabbledPane(printWordFrequency(str), printNumberFrequency(arr) ," Frequency "));
		 frame.setSize(500,500);
		 frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
//		printNumberFrequency(arr);
//		printWordFrequency(str);
//		printFrequency(arr);
		

	}

	

	private static JScrollPane printNumberFrequency(int[] arr) {
		/*
		 *  We are using MAP top solve this
		 *  
		 *  As we know Map holds data as key-value pair and does not allow any duplication of the key 
		 *  Approach :
		 *    Iterate over  the given array 
		 *    get(ar[ith position ]) as key 
		 *    use a counter variable to keep track of the occurrence 
		 *   check for : whether get(ar[i]) is null then this will be the single occurrence of the value
		 *   else do
		 *    put ar[i] as key and increment counter value as put is as value 
		 *   print the key and value 
		 * */
		Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		for (int j : arr) {
			Integer occurrence = hashMap.get(j);
			//if it is the first occurrence of the element
			if (hashMap.get(j) == null)
				hashMap.put(j, 1);
				//if element already exists in the hashmap object
			else
				hashMap.put(j, ++occurrence);
		}
		//print the result 
		for(@SuppressWarnings("rawtypes") Map.Entry mpentry : hashMap.entrySet() )
			System.out.println(" Element " + mpentry.getKey() +" occurred : " + mpentry.getValue() + " times.");
		
		//call tableConstruct and return tableconstruct object
		tableConstruct obj = tableConstruct.getInstance();
		
		return obj.geTable(hashMap);
		
	}

	private static JScrollPane printWordFrequency(String str) {
		/*
		 * same concept is being applied as HashMap
		 * As we know HaspMap does not retain a insertion order but TreeMap does
		 * Hence if output needs to be in a sorted manner then we can use the TreeMap object 
		 * 
		 * */
		Map<Character, Integer> treeMap = new TreeMap<Character, Integer>();
		for( int i =0; i < str.length(); i++) 
		{
			Integer occurrence = treeMap.get(str.charAt(i));
			//if it is the first occurrence of the element 
			if( treeMap.get(str.charAt(i)) == null )
				treeMap.put(str.charAt(i), 1);
			//if element already exists in the hashmap object 
			else
				treeMap.put(str.charAt(i),++occurrence );	
		}
		
		//print the result 
				for(@SuppressWarnings("rawtypes") Map.Entry mpentry : treeMap.entrySet() )
					System.out.println(" Element " + mpentry.getKey() +" occurred : " + mpentry.getValue() + " times.");
				//call tableConstruct and return tableconstruct object
				tableConstruct obj = tableConstruct.getInstance();
				
				return obj.geTable(treeMap);
		
	}
	
	@SuppressWarnings("unused")
	private static void printFrequency(int[] arr) {
		/*
		 * This method explains the usage of Collection.frequency() method in order to find the occurrence Of the element or letter 
		 * 
		 * */
		List<int[]> arrayList = new ArrayList<int[]>(Collections.singletonList(arr));
		Iterator<int[]> itr = arrayList.iterator();
//		while(itr.hasNext()) {
//			System.out.println(" Element " + itr.next() +" occurred : " + Collections.frequency(arrayList, itr.next()) + " times.");
//		}
		System.out.println(" Element 90"   +" occurred : " + Collections.frequency(arrayList, 90) + " times.");
		
	}

}
