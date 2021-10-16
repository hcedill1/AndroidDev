package edu.asu.cidse.se.hashmap;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //has maps allows you to store key value pairs
        //we must import hashmap into project
        //in hasmap we want to pass values as objects
        HashMap<String, Integer> gameStats = new HashMap<>();

        //we use put to add items into the hashmap
        gameStats.put("James",100);
        gameStats.put("Ruth",457);
        gameStats.put("Carolina",679);
        //there is not order when it comes to adding things into the hashmap
        System.out.println(gameStats);

        //how do we access Ruth 457
        //if you notice the .get wants you to pass  an object and it reutnrs an integer
        //so remember that string is an object and so we are going to pass "Ruth"
        //so it will go ahead and print out the value.
        System.out.println(gameStats.get("Ruth"));

        //so we want to remove so it requires you to pass an object
        gameStats.remove("James");

        System.out.println(gameStats);

        System.out.println(gameStats.size());

        System.out.println("\n");

        //we will have for each in order to travers through the hashmap
        //so we are going to pass the actual variable that will be holding the variiables that are
        // going to display.
        //for each item that will we get from the keyset we will put it into the :item
        for(String item : gameStats.keySet()){
            System.out.println(item);
        }

        System.out.println("Printing out values");

        //what if we want to get the values

        for (Integer item : gameStats.values()) {
            System.out.println(item);
        }

        //we are going to envoke(get) and get out keys and values at the same time

        for (String item : gameStats.keySet()) {

            System.out.println("Key: " + item + " value " + gameStats.get(item));
        }

    }
}