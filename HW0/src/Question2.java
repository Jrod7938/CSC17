import java.io.IOException;
import java.util.Scanner;

public class Question2 {
    private double mmToft(double mm){
        double ft = mm * 0.0033; // 1mm = 0.0033ft
        return ft;
    }

    private double mToin(double m){
        double in = m * 39.37; // 1m = 39.37in
        return in;
    }

    private double kmToyd(double km){
        double yd = km * 1093.61; // 1km = 1,093.61
        return yd;
    }

    public static void main(String[] args) throws IOException{
        Question2 test = new Question2();

        double interact = 0.00;

        while(interact != 4){
            System.out.println("1. Convert millimeters to feet.\n2. Convert meters to inches.\n3. Convert kilometers to yards.\n4. Quit");
            System.out.print("Selection: ");

            Scanner in = new Scanner(System.in);
            interact = in.nextDouble();

            //  Millimeter to feet conversions
            if(interact == 1){
                System.out.print("Millimeters: ");
                Scanner input = new Scanner(System.in);
                double mm = input.nextDouble();
                input.close();
                System.out.println(test.mmToft(mm) + " ft");
                
                
            //  Meter to Inches conversion
            } else if(interact == 2) {
                System.out.print("Meters: ");
                Scanner input = new Scanner(System.in);
                double m = input.nextDouble();
                input.close();
                System.out.println(test.mToin(m) + " in");
                
            
            //  Kilometers to Yard conversion
            } else if(interact == 3) {
                System.out.print("Kilometers: ");
                Scanner input = new Scanner(System.in);
                double km = input.nextDouble();
                input.close();
                System.out.println(test.kmToyd(km) + " yd");
                
            }
            
        }
    }
}
