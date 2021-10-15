package edu.asu.cidse.se.contructorinheritance;

public class JavaContructorInheritance {
    public static void main(String[] args) {
        //when you instantiate a class you add a "new" which means
        //you are creating an object of a class
        Person person = new Person("James",56);

        System.out.println(person.age);

        //because hero extends person, you are able to grab name and age from person,
        //and we have power from the Hero class.

        Hero superman = new Hero("Super Man", 123,345);

        System.out.println(superman.power);

    }
}