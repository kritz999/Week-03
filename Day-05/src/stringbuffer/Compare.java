package stringbuffer;

public class Compare {
    public static void main(String[] args) {
        int n = 1_000_000; // Number of strings to concatenate
        String text = "hello"; // Sample text to append

        // Measure time for StringBuffer
        long startTimeBuffer = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = (endTimeBuffer - startTimeBuffer) / 1_000_000; // Convert to milliseconds

        // Measure time for StringBuilder
        long startTimeBuilder = System.nanoTime();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbd.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long durationBuilder = (endTimeBuilder - startTimeBuilder) / 1_000_000; // Convert to milliseconds

        // Output the results
        System.out.println("Time taken by StringBuffer: " + durationBuffer + " ms");
        System.out.println("Time taken by StringBuilder: " + durationBuilder + " ms");

        // Performance comparison
        if (durationBuffer > durationBuilder) {
            System.out.println("StringBuilder is faster by " + (durationBuffer - durationBuilder) + " ms.");
        } else {
            System.out.println("StringBuffer is faster by " + (durationBuilder - durationBuffer) + " ms.");
        }
    }
    }

