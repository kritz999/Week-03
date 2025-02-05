package ChallengeProblem;
import java.io.*;
import java.util.StringTokenizer;

public class ChallengeProblem {



        public static void main(String[] args) {
            compareStringBuilderAndBuffer();

            String filePath = "sample.txt";
            compareFileReaders(filePath);
        }

        public static void compareStringBuilderAndBuffer() {
            String str = "hello";
            int iterations = 1_000_000;


            long startTime = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < iterations; i++) {
                sb.append(str);
            }
            long stringBuilderTime = System.nanoTime() - startTime;
            System.out.println("StringBuilder Time: " + (stringBuilderTime / 1_000_000) + " ms");


            startTime = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < iterations; i++) {
                sbf.append(str);
            }
            long stringBufferTime = System.nanoTime() - startTime;
            System.out.println("StringBuffer Time: " + (stringBufferTime / 1_000_000) + " ms");
        }

        public static void compareFileReaders(String filePath) {
            try {

                long startTime = System.nanoTime();
                int wordCount1 = countWordsUsingFileReader(filePath);
                long fileReaderTime = System.nanoTime() - startTime;
                System.out.println("FileReader Word Count: " + wordCount1 + ", Time: " + (fileReaderTime / 1_000_000) + " ms");


                startTime = System.nanoTime();
                int wordCount2 = countWordsUsingInputStreamReader(filePath);
                long inputStreamReaderTime = System.nanoTime() - startTime;
                System.out.println("InputStreamReader Word Count: " + wordCount2 + ", Time: " + (inputStreamReaderTime / 1_000_000) + " ms");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static int countWordsUsingFileReader(String filePath) throws IOException {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            int wordCount = 0;
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }

            br.close();
            return wordCount;
        }

        public static int countWordsUsingInputStreamReader(String filePath) throws IOException {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
            BufferedReader br = new BufferedReader(isr);
            int wordCount = 0;
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }

            br.close();
            return wordCount;
        }
    }


