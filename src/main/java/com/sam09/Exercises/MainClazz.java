package com.sam09.Exercises;

/*
* List<Integer> list=....
Thread1 => it will add 1 to 15 in list
Thread2 =>it will ad 16 to 30 in list
Thread3 =>it will add 31 to 50 in list

 Thread4 =>will print all element available in list
* */

abstract class parentAbs {
    public parentAbs(int a) {
        System.out.println("value: " + a);
    }
}
class parent {
     public void show() {
        System.out.println("From Parent");
    }
}

class child extends parent {

    /*public child(int a) {
        super(a);
        System.out.println("Child value: " + a);
    }*/
    public child() {
        super();
    }

    public void show() throws ArithmeticException {
        /*super.show();*/
        System.out.println("From Child");
    }
}

public class MainClazz {
    public static void main(String[] args) {
        /*child child = new child(2);*/
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a==b);
        System.out.println(c==b);
        c = c.intern();
        System.out.println(c==a);

       /* incompatible types: com.sam09.Exercises.parent cannot be converted to com.sam09.Exercises.child
       child obj = new parent();*/
//       obj.show();
    }
}

