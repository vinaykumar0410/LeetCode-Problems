
// Tag - Medium
class Solution {
    public int[] sortArray(int[] nums) {
        // Base case: if the array has only one element, it's already sorted
        if (nums.length == 1) {
            return nums;
        }
        
        // Find the middle point to divide the array into two halves
        int mid = nums.length / 2;
        
        // Recursively sort the left half
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        // Recursively sort the right half
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        
        // Merge the two sorted halves
        return mergeSort(left, right);
    }

    int[] mergeSort(int[] left, int[] right) {
        // Create an array to store the merged result
        int[] ans = new int[left.length + right.length];
        
        int i = 0; // Pointer for left array
        int j = 0; // Pointer for right array
        int k = 0; // Pointer for the merged array
        
        // Merge the two arrays while there are elements in both
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ans[k++] = left[i++]; // Take element from left array
            } else {
                ans[k++] = right[j++]; // Take element from right array
            }
        }
        
        // Copy any remaining elements from the left array
        while (i < left.length) {
            ans[k++] = left[i++];
        }
        
        // Copy any remaining elements from the right array
        while (j < right.length) {
            ans[k++] = right[j++];
        }
        
        // Return the merged array
        return ans;
    }
}
