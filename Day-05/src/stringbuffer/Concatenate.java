package stringbuffer;

public class Concatenate {

    public static String concatenateStrings(String[] strings) {
        // Initialize StringBuffer for efficient concatenation
        StringBuffer sb = new StringBuffer();

        // Iterate through each string and append to StringBuffer
        for (String str : strings) {
            sb.append(str);
        }

        // Convert StringBuffer to String and return
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java."};

        // Concatenating strings using StringBuffer
        String result = concatenateStrings(words);

        // Output the concatenated result
        System.out.println("Concatenated String: " + result);
    }
    }

