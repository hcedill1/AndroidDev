package edu.asu.cidse.se.methodsandparams;

public class MyClass {
    public static void main(String[] args) {

        /*
        Exercise 2 Code runner implementation
         */
        int command = 1;

        System.out.println(running(command));




    }

    public static String running(int command){

        if(command == 0){
            return "CodeRunner running North";
        }else if(command == 1){
            return "CodeRunner running South";
        }else if(command == 2){
            return "CodeRunner running West";
        }else if(command == 3){
            return "CodeRunner running East";
        }else if(command >= 4 || command < 0){
            return "CodeRunner is confused - doesnt know where to go";
        }else{
            return "Unknown command";
        }
    }

}