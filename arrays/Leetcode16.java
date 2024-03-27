
// Tag - Medium (same as 3sum)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int currentSum = nums[i] + nums[j] + nums[k];
                if(currentSum < target) j++;
                else k--;
                // Update the result if the current triplet has a closer sum to the target.
                if(Math.abs(currentSum-target) < Math.abs(result-target)){
                    result = currentSum;
                }
            }
        }
        return result;
    }
}

