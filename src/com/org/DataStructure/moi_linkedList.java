package com.org.DataStructure;

/**
 * @author Sam
 * @version 1.0
 *
 */
public class moi_linkedList {
   
	public node Head; // to keep a track of the head of the linked list 
	//inner class named as node
	public static class node{
		String data;
		int dataInt;
		public node next;
		 public node(String data){
			this.data = data;
			next = null;
		}
		 public node(int dataInt){
				this.dataInt = dataInt;
				next = null;
			}
	}
	
	public void addToHead(String data){
		
			node newNode = new node(data);
			newNode.next = Head;
			Head=newNode;
			System.out.println("Data added the list successfully\n");
	}
	public void addToHead(int data){
		
		node newNode = new node(data);
		newNode.next = Head;
		Head=newNode;
		int test=newNode.dataInt;
		test = Head.dataInt;
		System.out.println("Data added the list successfully\n");
}
	
	public void addToTail(String data){
		
		node newNode = new node(data);
		if(Head == null ){
			Head = newNode;return;}
		else{ // get a pointer to Head and traverse till the last node of the list
			node lastNode = Head;
			while( lastNode.next != null) 
				lastNode = lastNode.next;
			lastNode.next = newNode;
		}
		System.out.println("Data added the list successfully\n");
	}
public void addToTail(int data){
		
		node newNode = new node(data);
		if(Head == null ){
			Head = newNode;return;}
		else{ // get a pointer to Head and traver till the last node of the list
			node lastNode = Head;
			while( lastNode.next != null) 
				lastNode = lastNode.next;
			lastNode.next = newNode;
		}
		System.out.println("Data added the list successfully\n");
	}
	
	@SuppressWarnings("unused")
	public void addAt(String key , String data ){
		
		node previousNode = Head;
		while( previousNode.data != key){
			previousNode = previousNode.next;
		}
		
		if(previousNode == null)
			System.out.println("Given node data can not be null\n");
		else{
			node newNode = new node(data);
			newNode.next = previousNode.next;
			previousNode.next = newNode;
		}
		System.out.println("Data added the list successfully\n");
	}
	
	public void dropList(){
		Head = null;
		System.out.println("List dropped successfully\n");
	}
	
	public void delNode(String key){
		node tempNode = Head;
		node prevNode = null;
		if( tempNode != null && tempNode.data == key)
			Head = tempNode.next;
		while( tempNode != null && tempNode.data != key){
			prevNode = tempNode;
			tempNode = tempNode.next;
		}
		if(tempNode == null)
			return;
		prevNode.next = tempNode.next;
		System.out.println("Node deleted successfully\n");
	}
	
	public String getList(String delimeter){
		node n = Head;
		String listItem = "";
		while(n != null){
			listItem += n.data + delimeter;
			n = n.next;
		}
		return listItem.substring(0, listItem.length() - delimeter.length());
		
	}
	public void rotate(int rotation_index) {
		 if(rotation_index == 0)
		 {
			 System.out.println(" rotation_index must be > 0");
		 }		
		 
		 node currentNode = Head;
		 int counter =0;
		 // traversing to the asked index 
		 while( counter < rotation_index && currentNode != null) {
			 currentNode = currentNode.next;
			 counter++;
		 }
		 if( currentNode == null)
		 {
			 System.out.println("rotation_index is EITHER > count of list OR rotation_index = count of list ");
		 }
		 
		 node asked_rotation_index = currentNode;
		 
		 while( currentNode != null) 
			 currentNode = currentNode.next;
		 
		 currentNode.next = Head;
		 
		 //making asked index as Head of the list 
		 Head = asked_rotation_index;
	}
//	public void push(int data) {
//		
//		node newNode = new node(data);
//		newNode.next = Head;
//		Head=newNode;
//	}

}
