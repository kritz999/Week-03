package linearsearch;

public class SpecificWord {

    public static String Word(String[]array,String word){

       for(String s :array){
           if(s.contains(word)){
               return s;
           }
       }
        return "not found";
    }
    public static void main(String[] args) {
        String[] array ={"hello", "my name is", "vinayak"};
        String word = "my";
        System.out.println( Word(array,word));


    }
}
