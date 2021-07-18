package com.Exercises;

public class ConstructorOverloading {
private double width,height;
	public ConstructorOverloading(){
	height=-1;
	width=-1;
	System.out.println("Default Constructor is iNVOKED");
}
	public ConstructorOverloading(double side){
		width=height=side;
		
	}
	public ConstructorOverloading(double height,double width){
		this.height=height;
		this.width=width;
	}
	public double display(){
		return height*width;
	}
	public static void main(String[] args) {
		ConstructorOverloading ob1=new ConstructorOverloading();
		ConstructorOverloading ob2=new ConstructorOverloading(4);
		ConstructorOverloading ob3=new ConstructorOverloading(4,6);
		ob1.display();
		System.out.println("Area of Square is:- "+ob2.display());
		System.out.println("Area of Rectangle is:- "+ob3.display());
	}

}
