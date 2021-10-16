package edu.asu.cidse.se.sortingarrays;

import static java.util.Arrays.sort;
public class Main {
    public static void main(String[] args) {
        int [] arr = {3,12,0,1};

        System.out.println("Before sort...");

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

      sort(arr);

        System.out.println("After sort...");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }



    }
}