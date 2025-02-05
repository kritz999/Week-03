package inputstreamreader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class ReadWrite {

    public static void main(String[] args) throws IOException {

        String filename ="sample.txt";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        FileWriter fw = new FileWriter(filename,true);
        BufferedWriter bw = new BufferedWriter(fw);

        try{
                /*InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);
                FileWriter fw = new FileWriter(filename,true);
                BufferedWriter bw = new BufferedWriter(fw);*/

            System.out.println("enter the text and type exit to stop");

            String line;
            while(true){
                line = br.readLine();
                if(line.equalsIgnoreCase("exit")){
                    break;
                }
                bw.write(line);
                bw.newLine();
            }
            System.out.println("data successfully written"+filename);
        }catch(IOException e){
            System.out.println("error occured"+e.getMessage());
        }


    }
}
