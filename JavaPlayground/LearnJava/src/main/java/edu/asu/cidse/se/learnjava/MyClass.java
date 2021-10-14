package edu.asu.cidse.se.learnjava;

public class MyClass {

    public static void main(String[] args) {

        int a = 8;
        int b = 90;
        boolean check = true;
        boolean check1 = false;
        /*
        -- Relational Operators --
        != --> not equal
        == -->equal
        >= --> greater than or equal to
        <= --> less than or equal to

        -- Logical Operators--
        ! => only when its by itself.

        --Conidtional Operators
        || and &&
         */

//        if(a == b){
//            System.out.println("They are equal");
//        }else if(a > b){
//            System.out.println("A is bigger than B");
//        }else{
//            System.out.println("B is bigger than A");
//        }

        /*
        This will end up alsways becoming true becuase of the ||
         */

//        if((check) || (a < b) && check1){
//            System.out.println("True");
//        }else{
//            System.out.println("False");
//        }

        /*
        Exercise 1 Switch Statement
         */
        String command = "Withdraw";
        String command1 = "Deposit";

        int balanced = 1000;
        int amount = 100;

        switch (command1){
            case "Withdraw":
                System.out.println(balanced - amount);
                break;
            case "Deposit":
                System.out.println(balanced + amount);
                break;
            default:
                System.out.println("Cannot find request");
        }
    }
}