package FileReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReader2 {
    public static void main(String[] args) {
        String filename = "sample2.txt";
        int counter=0;
        String line;
        String target ="kritika";
        try(BufferedReader br2 = new BufferedReader(new FileReader("sample2.txt"))) {

            while ((line = br2.readLine()) != null) {
                //split the line into words using white spaces and punctuation

                String[] words = line.split("[\\s.,!?;:()\"]+");

                for (String word : words) {
                    //.equalsIgnoreCase returns boolean value
                    //ignores uppercase and lowercase
                    if (word.equalsIgnoreCase(target)) {
                        counter++;
                    }
                }
            }
            System.out.println("The targeted word "+target + " the number of times it occured "+counter +" times");
        }

        catch(IOException e){
            System.out.println("error reading file :"+e.getMessage());
        }
    }
}
