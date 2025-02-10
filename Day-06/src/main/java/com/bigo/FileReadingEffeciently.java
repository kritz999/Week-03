package com.bigo;
import java.io.*;
public class FileReadingEffeciently {


        private static final String FILE_PATH = "largefile.txt";

        public static void main(String[] args) {
            // Generate a large test file (only once needed)
            generateLargeFile(FILE_PATH, 500 * 1024 * 1024); // 500MB

            // Measure FileReader performance
            long fileReaderTime = measureFileReader(FILE_PATH);
            System.out.println("FileReader Time: " + fileReaderTime + " ms");

            // Measure InputStreamReader performance
            long inputStreamReaderTime = measureInputStreamReader(FILE_PATH);
            System.out.println("InputStreamReader Time: " + inputStreamReaderTime + " ms");
        }

        // Generates a large file with random characters
        private static void generateLargeFile(String filePath, int sizeInBytes) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                char[] buffer = new char[1024];
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (char) ('A' + (Math.random() * 26));
                }
                int iterations = sizeInBytes / buffer.length;
                for (int i = 0; i < iterations; i++) {
                    writer.write(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static long measureFileReader(String filePath) {
            long start = System.currentTimeMillis();
            try (FileReader fileReader = new FileReader(filePath)) {
                while (fileReader.read() != -1) {
                    // Reading character by character (inefficient for large files)
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return System.currentTimeMillis() - start;
        }

        private static long measureInputStreamReader(String filePath) {
            long start = System.currentTimeMillis();
            try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
                while (inputStreamReader.read() != -1) {
                    // Reading character by character (byte stream more efficient)
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return System.currentTimeMillis() - start;
        }
    }

