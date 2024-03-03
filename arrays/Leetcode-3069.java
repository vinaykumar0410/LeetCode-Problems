
// Tag - Easy
import java.util.*;

class Solution {
    public int[] resultArray(int[] nums) {
        // List for the first & second subsequence.
        List<Integer> arr1 = new ArrayList<>(); 
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]); // Add the first element to the first subsequence.
        if (nums.length > 1) arr2.add(nums[1]); // Edge case
        
        for (int i = 2; i < nums.length; i++) {
            // If the last element of arr1 is greater than the last element of arr2, add the current element to arr1.
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]); 
            } else {
                // Otherwise, add the current element to arr2.
                arr2.add(nums[i]); 
            }
        }

        // Merge arr2 into arr1.
        arr1.addAll(arr2); 

        // Create an array to hold the result.
        int[] array = new int[nums.length]; 
        // Convert List to array.
        for(int i=0; i<arr1.size(); i++) array[i] = arr1.get(i); 
        
        return array; // Return the merged array.
    }
}
