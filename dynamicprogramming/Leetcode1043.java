
// Tag - Medium

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(0,arr,k,memo);
    }
    private int helper(int i,int[] arr,int k,int[] memo){
        if(i == arr.length){
            return 0;
        }
        if(memo[i] != -1){
            return memo[i];
        }
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for(int j=i; j<Math.min(arr.length,i+k); j++){
            max = Math.max(max,arr[j]);
            int sum = max*(j-i+1) + helper(j+1,arr,k,memo);
            ans = Math.max(ans,sum);
        }
        return memo[i] = ans;
    }
}