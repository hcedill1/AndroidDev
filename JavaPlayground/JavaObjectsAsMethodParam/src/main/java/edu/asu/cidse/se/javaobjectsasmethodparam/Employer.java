package edu.asu.cidse.se.javaobjectsasmethodparam;

public class Employer {
    private String name;
    private String location;

    public Employer(){

    }

    public Employer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    //we can pass objects so we can abstract the information from the employee
    public void employeeDetails(Employee employee){
        System.out.println("ID: " + employee.getIdNumber() + " Name: " + employee.getFirstName()
        + " " + employee.getLastName() + "Department: " + employee.getDepartment() +
                " Position: " + employee.getPosition() + " Monthly Salary: " + employee.getMonthlySalary());
    }

    public void calculateAnnualBonus(Employee employee){
        double annualBonus = (employee.getMonthlySalary() * .15) * 11;

        System.out.println("Annual bonus for " + employee.getFirstName() + " is " + annualBonus);
    }

    //check if two employees are related
    public boolean areRelated(Employee employeeA, Employee employeeB){
        if(employeeA.getLastName().equals(employeeB.getLastName())){
            return true;
        }else{
            return false;
        }
    }




}
