package edu.asu.cidse.se.contructorinheritance;
//using extends mean it inherits a person
public class Hero extends Person {
    int power;
    //because a hero is extending you cannot inherit persons contructor
    //remember that constructors are unique methods that help construct an object,
    //when instantiated has some initial state or values.
    public Hero(String name, int age,int power) {
        //cannot inherit constructor
        super(name, age);
        this.power = power;
    }
}
