package edu.asu.cidse.se.inheritanceonly;
//we are creating levels of hiararchy
public class Employee extends Person{

    private int id;
    private double annualSalary;


    public Employee(String firstName, String lastName, int age, int id,double annualSalary) {
        super(firstName, lastName, age);
        this.id = id;
        this.annualSalary = annualSalary;
    }

    public Employee() {

    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
