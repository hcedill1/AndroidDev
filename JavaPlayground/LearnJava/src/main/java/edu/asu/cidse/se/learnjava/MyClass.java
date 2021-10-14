package edu.asu.cidse.se.learnjava;

public class MyClass {

    public static void main(String[] args) {

        int a = 8;
        int b = 90;

        /*
        -- Relational Operators --
        != --> not equal
        == -->equal
        >= --> greater than or equal to
        <= --> less than or equal to

        -- Logical Operators--
        ! => only when its by itself.
         */

        if(a == b){
            System.out.println("They are equal");
        }else if(a > b){
            System.out.println("A is bigger than B");
        }else{
            System.out.println("B is bigger than A");
        }
    }
}