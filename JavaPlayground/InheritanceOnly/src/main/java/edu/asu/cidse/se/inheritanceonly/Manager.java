package edu.asu.cidse.se.inheritanceonly;
//this will grab all the properties of employee and person
public class Manager extends Employee{

    //this will override the getSalary from Employee
    //so the super is the employee so we want to return our own getSalary
    //what you can do is add another 10000
    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary() + 10000;
    }

    //this is inheriting from the super class object
    @Override
    public String toString(){
        return this.getFirstName() + " , " + this.getAnnualSalary();
    }

}
