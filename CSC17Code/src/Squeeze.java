import java.util.Scanner;

public class Squeeze { 
    public static String squeeze(String s) {
        String str = s.replaceAll("\\s+", " ");
		return str;
    }

    public static void main(String[] args) { 
        Scanner in = new Scanner(System.in);
        
        String s = in.nextLine();

        System.out.println(squeeze(s));
        in.close();
    }
}