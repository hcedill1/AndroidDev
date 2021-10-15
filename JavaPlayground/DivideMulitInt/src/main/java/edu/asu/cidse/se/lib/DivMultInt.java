package edu.asu.cidse.se.lib;

public class DivMultInt{

    public static void main(String[] args) {

        System.out.println(divideNumbers(10,2));
        System.out.println("\n");
        System.out.println(multiplyNumbers(10,2));

    }

    public static int divideNumbers(int firstNumber, int secondNumber){
        int quotient = 0;
        quotient = firstNumber / secondNumber;

        return quotient;
    }
    public static int multiplyNumbers(int firstNumber, int secondNumber){
        int multiple = 0;

        multiple = firstNumber * secondNumber;

        return multiple;

    }

}