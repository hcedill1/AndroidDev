package edu.asu.cidse.se.javaobjectsasmethodparam;

public class Main {
    public static void main(String[] args) {

        Employer bank = new Employer();

        Employee Jenna = new Employee("Jenna","Lassoft",
                12343,"HR","Recruiter",4500.89);

        Employee Lance = new Employee("Lance","K.",
                45656,"IT","IT/Support",3800.56);

        bank.calculateAnnualBonus(Jenna);
        bank.calculateAnnualBonus(Lance);
        bank.employeeDetails(Lance);

        boolean related = bank.areRelated(Jenna,Lance);

        System.out.println(related);
    }
}