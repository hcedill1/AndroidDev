package edu.asu.cidse.se.datastructures;

import java.util.ArrayList;

public class DataStructures {
    public static void main(String[] args) {
        //Array list we can do more object oriented tasks

        //creating an array list or you can do ArrayList <String>  name = new ArrayList<>();
        ArrayList name = new ArrayList();
        name.add("Hernan");
        name.add("Bond");
        name.add("Arnold");
        name.add("James");

        //array list doe not contains length but has size();
        for(int i = 0; i < name.size(); i ++){
            System.out.println("Names " + name.get(i));
        }

        //another way to loop
        //the reason why the loop will change into Object is because the array list that
        //we have created is really Generic, which means that any type can be inside the list
        for(Object names : name){
            System.out.println(names);
        }

        //you can pass arrays through parameters
        int[] numArr = {12,0, 34, 100,34,2,3,5,19,78,69,12349};

        findMultThree(numArr);
    }
    //we are passing the arrays as parameters
    public static void findMultThree(int []nums){

        if(nums.length > 0){
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] % 3 == 0){
                    System.out.println(nums[i] +  " is a multiple of 3");
                }else{
                    System.out.println(" x " + nums[i] + " is not a multiple of 3" );
                }
            }
        }else{
            System.out.println("Empty array");
        }
    }


}