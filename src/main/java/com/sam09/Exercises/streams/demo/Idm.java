package com.sam09.Exercises.streams.demo;

public class Idm {
    int i;
    int j;
    public Idm() {}
    public Idm(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public static void main(String args[]) {
        Idm idm = new Idm();
        System.out.println(idm.i + "" + idm.j);
    }
}
