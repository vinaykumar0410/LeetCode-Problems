
// Tag - Medium

// Recursive Approach
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        // impossible to find target
        if(total-target < 0 || (total-target)%2==1){
            return 0;
        }
        total -= target;
        total /= 2;
        return helper(n-1,nums,total);
    }
    private int helper(int i,int[] nums,int target){
        // base case
        if(i < 0){
            return target == 0 ? 1 : 0;
        }
        // try all possible ways
        int skip = helper(i-1,nums,target);
        int take = 0;
        if(nums[i] <= target){
            take = helper(i-1,nums,target-nums[i]);
        }
        // return all ways
        return skip + take;
    }
}

// Using Cache/Memo
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        // impossible to find target
        if(total-target < 0 || (total-target)%2==1){
            return 0;
        }
        total -= target;
        total /= 2;
        // memo is used to stored computed values
        int[][] memo = new int[n][total+1];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        } 
        return helper(n-1,nums,total,memo);
    }
    private int helper(int i,int[] nums,int target,int[][] memo){
        // base case
        if(i < 0){
            return target == 0 ? 1 : 0;
        }
        // already cached ? just return that
        if(memo[i][target] != -1) return memo[i][target];
        // try all possible ways
        int skip = helper(i-1,nums,target,memo);
        int take = 0;
        if(nums[i] <= target){
            take = helper(i-1,nums,target-nums[i],memo);
        }
        // store & return ways
        return memo[i][target] = skip + take;
    }
}