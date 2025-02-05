package inputstreamreader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;

public class Convert {

    public static void main(String[] args)  {
        //1010  -> character
      String filename ="example.txt";

      try( FileInputStream fis =  new FileInputStream(filename);
         InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
         BufferedReader br = new BufferedReader(isr)){
          String line;
          while((line=br.readLine())!=null){
              System.out.println(line);
          }


      }catch(IOException e){
          System.out.println("IO error"+e.getMessage());
      }


    }

}
