import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;

public class Question4 {
    private int getNumber(){
        System.out.print("Enter a number: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        return num;
    }

    private int closestPrime(){
        int num = getNumber();

        // 0 and 2 are the only Even Prime Numbers
        if (num % 2 != 0){
            num -= 2;
        } else {
            num--;
        }

        int i, j;

        // Checking if the number is prime
        for (i = num; i >= 2; i -= 2) {
            if (i % 2 == 0)
                continue;
            for (j = 3; j <= Math.sqrt(i); j += 2) {
                if (i % j == 0)
                    break;
            }
            if (j > Math.sqrt(i))
                return i;
        }
 
        // Will only be executed when n is 3
        return 2;
    }

    public static void main(String[] args) throws IOException{
        Question4 test = new Question4();

        System.out.println("Closest Prime Number is: " + test.closestPrime());
    }
}
