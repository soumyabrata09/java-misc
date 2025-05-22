package com.sam09.Exercises.streams.demo;

abstract class Abs {
    public void m() {
        System.out.print("I am an Abstract");
    }
}
public class DrivemainClazz{
    public static void main(String a[]) {
        Abs obj = new Abs() {};
        obj.m();
    }
}

