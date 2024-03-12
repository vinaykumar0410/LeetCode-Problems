
// Tag - Medium
class Solution {
    public void sortColors(int[] nums) {
        // Pointer for the start of the sorted section for 0s.
        int start = 0; 
        // Pointer for traversing the array.
        int mid = 0; 
        // Pointer for the end of the sorted section for 2s.
        int end = nums.length - 1; 
        
        // Traverse the array until mid meets the end pointer.
        while (mid <= end) {
            // If the current element is 0, swap it with the element at the start pointer.
            // Increment both start and mid pointers.
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                start++;
                mid++;
            } 
            // If the current element is 1, move the mid pointer forward.
            else if (nums[mid] == 1) {
                mid++;
            } 
            // If the current element is 2, swap it with the element at the end pointer.
            // Decrement the end pointer.
            else {
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            }
        }
    }
}
