
// Tag - Medium

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int max = 0;
        // find bitwise or of all elements
        for(int num : nums){
            max |= num;
        }
        // helper function will return the number of subsets with bitwise or equal to max
        return helper(0,nums,max,0);
    }
    private int helper(int i,int[] nums,int max,int curr){
        // base case
        if(i == nums.length){
            return max == curr ? 1 : 0;
        }
        // recursively call for next index
        int skip = helper(i+1,nums,max,curr);
        int take = helper(i+1,nums,max,curr|nums[i]);
        // return all ways
        return skip + take;
    }
}