
// Tag - Medium
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Initialize list to store duplicates
        List<Integer> list = new ArrayList();
        // Initialize index pointer 
        int i = 0; 
        
        // Iterate through the array
        while(i < nums.length) {
            // Calculate the correct index for the current number
            int correctIndex = nums[i] - 1; 
            
            // If current number is within range and not in its correct position, swap it
            if(nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                // Move to the next number if it's already in its correct position or out of range
                i++; 
            }
        }
        
        // Iterate through the array again to find duplicates
        for(int j = 0; j < nums.length; j++) {
            // If number at index j is not equal to j+1, add it to list
            if(nums[j] != j + 1) list.add(nums[j]); 
        }
        
        // Return the list of duplicates
        return list; 
    }
}
