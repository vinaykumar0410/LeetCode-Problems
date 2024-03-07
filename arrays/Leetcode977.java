
// Tag - Easy
class Solution {
    public int[] sortedSquares(int[] nums) {
        // Initialize an array to store the squares of nums.
        int[] arr = new int[nums.length]; 
        // Pointers for the start and end of nums.
        int i = 0, j = nums.length - 1; 
        
        // Iterate over the array, filling arr with squares in non-decreasing order.
        for (int k = nums.length - 1; k >= 0; k--) {
            if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                arr[k] = nums[j] * nums[j];
                j--;
            } else {
                arr[k] = nums[i] * nums[i];
                i++;
            }
        }
        return arr; // Return the sorted squares array.
    }
}

