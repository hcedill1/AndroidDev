package edu.asu.cidse.se.inheritanceonly;
//the super class is known as the object class. that means that every class created is inherited by the object class

public class Ineritance {
    public static void main(String[] args) {

        Person james = new Person("James","Bond", 47);
        System.out.println(james.getAge());

        Employee employee = new Employee();
        employee.setFirstName("Hernan");
        employee.setLastName("Cedillo");
        employee.setAge(29);
        employee.setId(124556);

        System.out.println(employee.getFirstName());
        System.out.println(employee.getId());

        //this will inherit from employee and person
        //so you are able to use the methods and attributes from the parent classes
        Manager manager = new Manager();
        System.out.println("\n");
        manager.setFirstName("Manager George");
        //so you will be able to set a salary and it will change ont your get salary from
        //the override method from Manager, which will be 10000
        manager.setAnnualSalary(20000);
        System.out.println(manager.getAnnualSalary());
        System.out.println(manager.getFirstName());
        //the object of a class will not just print out the addres anymore,
        //since it has toString that is overriden. it will display the managers info
        System.out.println(manager);


        //this is a primitive which means that it is not an object so int double fload etc
        //is a primitive data type
        int a = 12;
        //string is an object which means that it can inehrit from object
        String myString = "Hello there";
        boolean isEmpty = myString.isEmpty();
        System.out.println(isEmpty);
        if(!isEmpty){
            System.out.println(myString);
        }else{
            System.out.println("Empty");
        }

    }


}