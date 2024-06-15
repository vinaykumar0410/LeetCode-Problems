
// Tag - Medium

class Solution {
    public int minIncrementForUnique(int[] nums) {
        // [1,2,2] -> [1,2,3]
        Arrays.sort(nums);
        int cnt = 0;
        for(int i=1; i<nums.length; i++){
            // found descending order
            if(nums[i-1] >= nums[i]){
                // calulate how much needed for ascending order
                cnt += nums[i-1]-nums[i]+1;
                // update same here
                nums[i] = nums[i-1]+1;
            }
        }
        return cnt;
    }
}