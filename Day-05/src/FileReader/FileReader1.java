package FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class FileReader1 {
    public static void main(String[] args) {

        String filename = "sample.txt";

       try(BufferedReader br = new BufferedReader(new FileReader("sample.txt"))){
           String line;

           while((line = br.readLine()) != null) {
               System.out.println(line);
           }
            }catch (IOException e){
               System.out.println("error reading file :"+e.getMessage());
           }
        }

       }


