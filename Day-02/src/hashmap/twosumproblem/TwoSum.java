package hashmap.twosumproblem;
import java.util.HashMap;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Hash map to store the index of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement (target - current element) is in the map
            if (map.containsKey(complement)) {
                // If found, return the indices
                return new int[] { map.get(complement), i };
            }

            // Store the index of the current element in the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (or throw an exception)
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Find the indices of the two numbers that add up to the target
        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

}
