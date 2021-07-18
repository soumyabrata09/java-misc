package com.Exercises;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BufferedReaderDemo {
	private final Logger logger = LoggerFactory.getLogger(BufferedReaderDemo.class);
	public void bubbleSort(int array[]){
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		logger.info("Sorted Array: ");
		for(int val:array)
			System.out.print(val+" ");
	}

	public static void main(String[] args) throws IOException{
   InputStreamReader isr=null;
   BufferedReader br=null;
   try{
	   
	   isr=new InputStreamReader(System.in);
	   br=new BufferedReader(isr);
	System.out.print("Enter number of array elements= ");
	int n=Integer.parseInt(br.readLine());
	int[] ar=new int[n];
	System.out.print("Enter elements into array= ");
	for(int i=0;i<n;i++){
		ar[i]=Integer.parseInt(br.readLine());
	}
	BufferedReaderDemo obj=new BufferedReaderDemo();
	obj.bubbleSort(ar);
   }
   catch(IOException ex){
	   ex.printStackTrace();
   }
   finally{
	   if(isr!=null)
		   isr.close();
	   if(br!=null)
		   br.close();
   }
	}

}
