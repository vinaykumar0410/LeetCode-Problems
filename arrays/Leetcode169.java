
// Tag - Easy
class Solution {
    public int majorityElement(int[] nums) {
        // Initialize the potential majority element
        int majorityElement = nums[0]; 
        // Initialize the count of majority element occurrences
        int count = 1; 

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If count becomes zero, update majorityElement to the current element
            if (count == 0) majorityElement = nums[i];
            // If the current element equals majorityElement, increment count
            if (nums[i] == majorityElement) count++;
            // If the current element is not equal to majorityElement, decrement count
            else count--;
        }

        // Return the majority element found
        return majorityElement; 
    }
}

/*

class Solution {
    public int majorityElement(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int count = 0;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]) count++;
            }
            if(count >= nums.length/2) return nums[i];
        }
        return 17;
    }
}
 */
