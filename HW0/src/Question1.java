import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Question1 {

    // a method that inputs and returns a double value
    private double getNumber(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Double: ");
        double num = Double.parseDouble(in.nextLine());
        return num;
    }
    private void returnNumber(){
        System.out.println("The double you entered is: " + this.getNumber());
    }

    // a method that takes two double parameters, adds them together, and returns the square root of the result
    private double doubleSqrt(double num1, double num2){
        double num = Math.sqrt(num1 + num2);
        return num;
    }
    private void returnDoubleSqrt(){
        double num1 = this.getNumber();
        double num2 = this.getNumber();
        System.out.println(num1 + " and " + num2 + " added and squared= " + doubleSqrt(num1, num2));
    }

    public static void main(String[] args) throws IOException{
        Question1 test = new Question1();

        test.returnNumber();

        test.returnDoubleSqrt();
    }
}


