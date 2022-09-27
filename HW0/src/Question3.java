import java.util.Scanner;
import java.io.*;


public class Question3 {
    private String getFileName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = in.nextLine();
        in.close();
        return filename;
    }

    public void showFile() throws IOException{
        String filename = getFileName();
        displayFileContent(filename);
    }

    private void displayFileContent(String filename) throws IOException{
        File file = new File(filename); //creates a new file instance
        FileReader fr = new FileReader(file); //reads the file
        BufferedReader br = new BufferedReader(fr); //creates a buffering character input stream
        String line;

        int numLines = 0;
        int numLetters = 0;

        while((line = br.readLine()) != null){
            numLines += 1;
            if(!line.equals("")){
                numLetters += line.length();
            }
        }

        fr.close(); //closes the stream and release the resources
        System.out.println("Number of lines: " + numLines + ".\nNumber of Letters: " + numLetters + ".");
    }

    public static void main(String[] args) throws IOException{
        Question3 test = new Question3();
        test.showFile();
    }
}
