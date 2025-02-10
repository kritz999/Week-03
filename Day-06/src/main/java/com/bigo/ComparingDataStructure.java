package com.bigo;
import java.util.*;

public class ComparingDataStructure {


        public static void main(String[] args) {
            int[] arr = {1000, 100000, 1000000};

            for (int size : arr) {
                System.out.println("Dataset Size: " + size);

                // Generate random numbers
                List<Integer> arrayList = new ArrayList<>();
                Set<Integer> hashSet = new HashSet<>();
                Set<Integer> treeSet = new TreeSet<>();

                Random random = new Random();
                for (int i = 0; i < size; i++) {
                    int num = random.nextInt(size * 10);
                    arrayList.add(num);
                    hashSet.add(num);
                    treeSet.add(num);
                }

                // Pick a random number to search
                int target = arrayList.get(random.nextInt(size));

                // Search in ArrayList (O(N))
                long start = System.nanoTime();
                boolean foundInArray = arrayList.contains(target);
                long end = System.nanoTime();
                System.out.println("ArrayList Search Time: " + (end - start) / 1e6 + " ms");

                // Search in HashSet (O(1))
                start = System.nanoTime();
                boolean foundInHashSet = hashSet.contains(target);
                end = System.nanoTime();
                System.out.println("HashSet Search Time: " + (end - start) / 1e6 + " ms");

                // Search in TreeSet (O(log N))
                start = System.nanoTime();
                boolean foundInTreeSet = treeSet.contains(target);
                end = System.nanoTime();
                System.out.println("TreeSet Search Time: " + (end - start) / 1e6 + " ms");

                System.out.println();
            }
        }
    }


