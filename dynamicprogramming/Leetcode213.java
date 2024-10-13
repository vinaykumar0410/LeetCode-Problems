
// Tag - Medium

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // edge case 
        if(n == 1) return nums[0];
        // init memo arrays
        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        // as start & end houses are adjacent
        // we can rob from 0th house to last but only 1 house or
        int case1 = helper(0,n-1,nums,memo1);
        // or we can rob from 1st house to last but only 1
        int case2 = helper(1,n,nums,memo2);
        return Math.max(case1, case2);
    }
    private int helper(int i,int n,int[] nums,int[] memo){
        if(i >= n) return 0;
        if(memo[i] != -1) return memo[i];
        int skip = helper(i+1,n,nums,memo);
        int take = nums[i] + helper(i+2,n,nums,memo);
        return memo[i] = Math.max(skip,take);
    }
}
