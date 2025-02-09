package linearsearch;
import java.util.*;
public class FirstNegElement {

    public static int display(int[]arr){

        int min =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
              min =arr[i];
              return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr= {1,2,3,4,5,-6};
        System.out.println();

        System.out.println(display(arr));

    }
}
