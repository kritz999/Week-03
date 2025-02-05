package BufferedBuilder;

import java.io.BufferedReader;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

    public static String display(String str){

        StringBuilder sb = new StringBuilder();
        LinkedHashSet ls = new LinkedHashSet<>();

        for(char ch : str.toCharArray()){
            if(!ls.contains(ch)){
                ls.add(ch);
                sb.append(ch);
            }
        }

        return sb.toString();

    }

  public static void main(String[] args) {

        String s ="kritika";
        String output = display(s);
      System.out.println(output);

    }
}
