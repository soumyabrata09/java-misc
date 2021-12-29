package com.sam09.Exercises;

import java.util.Scanner;

/**
 * @author Sam
 *
 */

/*
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer. 
 * For example, if the given linked list is 10->20->30->40->50->60 and k is 4, the list should be
 * modified to 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in linked list.
 * */

//Creating Linked List with Default access specifier 
class LinkedList{
	Node head;
	static class Node{
		int data;
		Node nextNode;
		Node(int data){
			this.data = data;
			nextNode = null;
		}
	}
	
	void add(int data) {
		Node newNode = new Node(data);
		newNode.nextNode = head;
		head = newNode;
	}
	
	void rotate(int r_index) {
		if(r_index == 0)
			System.out.println("Rotation Index must be greater than 0");
		Node currentNode = head;
		//traverse the node up to the given index number
		int count =1;
		while( count < r_index && currentNode != null) {
			currentNode = currentNode.nextNode;
			count++;
		}
		if (currentNode == null) 
            return;
		Node rTh_node = currentNode;
		//traverse the list with the currentNode up to null
		while(currentNode.nextNode != null) {
			currentNode = currentNode.nextNode; // at the end of the loop currentNode becomes the lastNode
//			int tdata=currentNode.data;
//			Node test = currentNode.nextNode;
		}
		currentNode.nextNode = head; // nextnode of the currently  pointing node should map to the headNode
		//change the head with the indexed node
		head = rTh_node.nextNode;
		rTh_node.nextNode = null;
	}
	
	String printList(String delimiter) {
		Node n = head;
		StringBuilder listItem = new StringBuilder();
		while( n!= null) {
			listItem.append(n.data).append(delimiter);
			n = n.nextNode;
		}
		
		return listItem.substring(0, listItem.length()-delimiter.length());
	}
	
}
public class RotateLinkedList {

	/**
	 * @param args for command line argument
	 */
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList(); 
		for (int i = 60; i >= 10; i -= 10) {
			list.add(i);
		}

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		/*System.out.println("Enter Range of list = ");
		int n = scanner.nextInt();*/
		//making the list
		//int standVal = 0;
		/*for(int i =0; i<n ; i++) {
			standVal += 10;
			list.addToHead(standVal);
		}
		for (int i = 60; i >= 10; i -= 10)
			list.push(i);*/
		System.out.println("::Before Rotation::");
		System.out.println(list.printList("->"));
		System.out.println("Enter rotation index = ");
		int ri = scanner.nextInt();
		list.rotate(ri);
		System.out.println("::After Rotation::");
		System.out.println(list.printList("->"));
	}

}
