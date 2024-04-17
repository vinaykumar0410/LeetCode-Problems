
// Tag - Easy
class Solution {
    public List<String> summaryRanges(int[] nums) {
        // Initialize a list to store the summary ranges.
        List<String> list = new ArrayList();
        
        // Traverse the input array.
        for(int i=0; i<nums.length; i++){
            // Store the starting number of the range.
            int start = nums[i];
            
            // Continue iterating until the next number is consecutive.
            while(i+1 < nums.length && nums[i]+1 == nums[i+1]) i++;
            
            // If a range was found, add it to the summary list.
            if(start != nums[i]) 
                list.add(start + "->" + nums[i]);
            // Otherwise, add the single number as a range.
            else 
                list.add(String.valueOf(start));
        }
        
        // Return the summary list.
        return list;
    }
}
