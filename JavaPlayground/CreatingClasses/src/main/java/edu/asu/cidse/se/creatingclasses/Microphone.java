package edu.asu.cidse.se.creatingclasses;

public class Microphone {
    //this class is a blueprint
    //instance variables/ properities/ fields
    //now in order to protect the attributes in this class, we will have to set a private.
    private String name;
    private String color;
    private int model;

    //a constructor is kind of like a method
    //so when you have an  empty constructor it create a spot in memory that is empty
    // so when we add a constructor it has a spot in memory but with info
    //it is good to add a different layer to the class

    //constructor is to construct something so what are the things
    //that we need to use to construct our class
    //we are passing the name color and model
    //it doesnt matter if you change the names of the attributes because they are equal to "this.name"
    //the constructor always has to have a the same name as the class becuase when you
    //instantiate it you pretty much add it as a method.
    public Microphone(String name, String color, int model){
        this.name = name;
        this.color = color;
        this.model = model;
    }

    //for every class you are able to add another constructor so when you create an object
    //of a class you can now use the empty one or the one with name . color . model
    public Microphone(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    //adding methods or actions
    public void turnOff(){
        
        System.out.println(this.name + " Turn off");
    }
    public void turnOn(){
        
        System.out.println(this.name + " Turn On");
    }
    public void setVolume(){
        //this means you are getting the property of this class
        System.out.println(this.name + " Setting volume ");
    }

    //this will return the description
    public String showDescription(){
        return "Microphone name " + this.name + " with color: "+
                this.color + " and its model: " + this.model;
    }




}
