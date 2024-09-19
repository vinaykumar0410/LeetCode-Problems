
// Tag - Medium

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        // partition is impossible if sum is odd
        if(total%2==1){
            return false;
        }
        total /= 2;
        // memo is used to store computed values
        Boolean[][] memo = new Boolean[n][total+1];
        return helper(n-1,nums,total,memo);
    }
    private boolean helper(int i,int[] nums,int target,Boolean[][] memo){
        // base case
        if(i == 0){
            return nums[i] == target;
        }
        // if already computed just return that
        if(memo[i][target] != null){
            return memo[i][target];
        }
        // skip curr element & move to next element
        boolean skip = helper(i-1,nums,target,memo);
        boolean take = false;
        // consider element only if it is less than or equal target & move to next element
        if(nums[i] <= target){
            take = helper(i-1,nums,target-nums[i],memo);
        }
        // store & return 
        return memo[i][target] = skip || take;
    }
}