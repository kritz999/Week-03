package hashmap.longestconsecutive;
import java.util.HashSet;
public class Solution {
    public int longestConsecutive(int[] nums) {
        // Edge case: if the array is empty
        if (nums.length == 0) {
            return 0;
        }

        // Create a hash set to store elements for O(1) lookups
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through each number in the set
        for (int num : numSet) {
            // Only check for the start of a sequence (num - 1 should not be in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Check for the next consecutive elements
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + solution.longestConsecutive(nums)); // Output: 4
    }

}
