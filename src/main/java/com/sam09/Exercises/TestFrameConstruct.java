package com.sam09.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//import com.org.swingComponents.frameConstruct;
import com.sam09.org.swingComponents.tableConstruct;

/**
 * @author Sam
 *
 */
public class TestFrameConstruct {

	/**
	 * @param args for command line argument
	 */
	public static void main(String[] args) {
		
		tableConstruct obj = tableConstruct.getInstance();
		Map<Integer, Integer> hmap = new HashMap<Integer,Integer>();
		for(int i =0; i<= 190; i++) {
			
			hmap.put(i+1, (new Random()).nextInt(100));
		}
		obj.getFrameTest(hmap);
		

	}

}
