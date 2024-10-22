
// Tag - Medium

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // init memo with -1 
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        // call helper method for max sum
        return helper(0,arr,k,memo);
    }
    private int helper(int i,int[] arr,int k,int[] memo){
        // base case
        if(i == arr.length){
            return 0;
        }
        // already computed just return that
        if(memo[i] != -1){
            return memo[i];
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        // try all possible paths to get max sum
        for(int j=i; j<Math.min(arr.length,i+k); j++){
            max = Math.max(max,arr[j]);
            int sum = max*(j-i+1) + helper(j+1,arr,k,memo);
            ans = Math.max(ans,sum);
        }
        // store & return max sum
        return memo[i] = ans;
    }
}