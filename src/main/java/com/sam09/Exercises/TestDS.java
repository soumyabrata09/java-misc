package com.sam09.Exercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.sam09.misc.Utility;
import com.sam09.org.DataStructure.moi_Stack;
import com.sam09.org.DataStructure.moi_linkedList;
import com.sam09.org.DataStructure.moi_linkedList.node;

/**
 * @author Sam
 *
 */
public class TestDS {

	/**
	 * @param list expects a linked list
	 * @param scanner expects a scanner object for input purposes at runtime
	 */
	public static void printHelper(Scanner scanner,moi_linkedList list){
        System.out.println("Please provide choice of your delimiter - ");
		
		System.out.println( "Your List currently contains :- "+list.getList( scanner.nextLine() ));
	}
	public static void printHelper() {
		System.out.println("Data stacked successfully");
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		List ll = new LinkedList();
		ll.add("Seasons");
		moi_linkedList list = new moi_linkedList();
		list.Head = new node("2"); // data inserted on the head of the list 
		node node2 = new node("3");
		node node3 = new node("4");
		node node4 = new node("6");
		list.Head.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		//print list items 
		try(Scanner scanner = new Scanner(System.in)){
		
		TestDS.printHelper(scanner, list);
		
		moi_Stack stack = new moi_Stack();
		for(int i = 65 ; i < 75; i +=2) {
//			char ch = (char)i; // cast to character from type int
//			String str = Character.toString(ch); // convert character to type String
//			System.out.println(ch);
			stack.push( Character.toString((char)i) );
			TestDS.printHelper();
		}
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		//System.out.println(stack.pop());System.out.println(stack.pop());System.out.println(stack.pop());System.out.println(stack.pop());
		System.out.println("If you want see real example then call reverseString():This method is implemented based upon stack\n"
				+ "Kindly enter a string of your choice below  which you want to reverse \n");
		Utility.reverseString( new Scanner(System.in).nextLine() );
		//more compact 
		//System.out.println( list.getList( (new Scanner(System.in)).nextLine() ));
		for(;;){
		System.out.println("Kindly select following operations :-  \n"
				+ "a/A to invoke addToHead( int data) \n"
				+ "b/B to invoke addToTail(int data) \n"
				+ "c/C to invoke addAt(int prevNode, int data) \n"
				+ "p/P to print the list "
				+ "DEL/del to drop the whole linkedlist"
				+ "d/D to invoke delNode()");
		switch( (new Scanner(System.in)).nextLine() ){
		case "a" :
		case "A" :
			//execute addToHead
			System.out.println( " Data -> " );
			String data = new Scanner(System.in).nextLine();
			list.addToHead(data);
			break;
		case "b" :
		case "B" :
			//execute addToTail
			System.out.println( " Data -> " );
			String data1 = new Scanner(System.in).nextLine();
			list.addToTail(data1);
			break;
		case "c" :
		case "C" :
//			//execute addAt
			System.out.println(" Node -> ");
			String data2 = new Scanner(System.in).nextLine();
			System.out.println( " Data -> " );
			String data3 = new Scanner(System.in).nextLine();
			list.addAt(data2,data3);
			break;
		case "p":
		case "P":
			TestDS.printHelper(scanner, list);
			break;
		case "DEL":
		case "del":
			list.dropList();
			break;
		case "d":
		case "D":
			System.out.println(" Node -> ");
			list.delNode((new Scanner(System.in)).nextLine());
			break;
		default :
			System.out.println("Unknown selection");
		}
		}
		//list.addAt(node3, 999);
		//testDS.printHelper(scanner, list);
		}
		catch(Exception ex){
			ex.getMessage();
		}

	}

}
