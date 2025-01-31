package gr.aueb.cf7.p2;

public class MaximumSubarray {

/**
 * Finds the maximum sum of a contiguous subarray within a given array.
 * @param nums the array of integers
 * @return the maximum sum of the contiguous subarray
*/

public static int maxSubArray(int[] nums) {
    // Initialize local_max and global_max with the first element of the array.
    int local_max = nums[0];
    int global_max = nums[0];

    // Iterate through the array starting from the second element.
    for (int i = 1; i < nums.length; i++) {
        // Update local_max to be the maximum of the current element and the sum
        // of the current element with the previous local_max.
        local_max = Math.max(nums[i], local_max + nums[i]);

        // Update global_max if local_max is greater.
        if (local_max > global_max) {
            global_max = local_max;
        }
    }

    return global_max; // Return the global maximum sum.
}

    /**
     * Main method to test the maxSubArray method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Example array to test the maxSubArray method.
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Print the maximum sum subarray.
        System.out.println("Maximum sum subarray: " + maxSubArray(nums)); // Output: 6
    }
}


