import java.io.IOException;
import java.util.Scanner;

public class Question2 {
    private double getNumber(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double num = Double.parseDouble(in.nextLine());
        return num;
    }
    private void mmToft(){
        double mm = this.getNumber();
        double ft = mm * 0.0033; // 1mm = 0.0033ft
        System.out.println(mm +"mm converted to ft= " + ft + "ft");
    }

    private void mToin(){
        double m = this.getNumber();
        double in = m * 39.37; // 1m = 39.37in
        System.out.println(m +"m converted to in= " + in + "in");
    }

    private void kmToyd(){
        double km = this.getNumber();
        double yd = km * 1093.61; // 1km = 1,093.61
        System.out.println(km +"km converted to yd= " + yd + "yd");
    }

    public static void main(String[] args) throws IOException{
        Question2 test = new Question2();

        int interact = 0;

        while(interact != 4){
            System.out.println("1. Convert millimeters to feet.\n2. Convert meters to inches.\n3. Convert kilometers to yards.\n4. Quit");
            System.out.print("Selection: ");

            Scanner in = new Scanner(System.in);
            interact = in.nextInt();

            if(interact == 1){
                test.mmToft();
            } else if(interact == 2) {
                test.mToin();
            } else if(interact == 3) {
                test.kmToyd();
            }
            in.close();
        }
    }
}
