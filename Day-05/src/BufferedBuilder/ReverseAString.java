package BufferedBuilder;
import java.util.Scanner;
public class ReverseAString {

    public static String display(String s){

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        //converting back to string because the sb is present in string builder form
        return sb.toString();
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string");
        String s = sc.nextLine();

        System.out.println(display(s));

    }
}
