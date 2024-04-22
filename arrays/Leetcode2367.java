
// Tag - Easy
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // Initialize a counter for arithmetic triplets
        int cnt = 0; 
        
        // Loop through the array until the second last element
        for(int i = 0; i < nums.length - 2; i++){
            // Loop through the array starting from the element after the current element
            for(int j = i + 1; j < nums.length; j++){
                // Loop through the array starting from the element after the next element
                for(int k = j + 1; k < nums.length; k++){
                    // Check if the difference between nums[j] and nums[i] and nums[k] and nums[j] is equal to the given difference
                    if(nums[j] - nums[i] == diff && nums[k] - nums[j] == diff){
                        cnt++; // Increment the counter if an arithmetic triplet is found
                    }
                }
            }
        }
        return cnt; // Return the count of arithmetic triplets
    }
}
