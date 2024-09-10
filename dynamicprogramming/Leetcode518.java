
// Tag - Medium

// Recursion
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return dfs(n-1,coins,amount);
    }
    private int dfs(int i,int[] coins,int amount){
        // valid base case 
        if(amount == 0){
            return 1;
        }
        // invalid base case
        if(i == -1 || amount < 0){
            return 0;
        }
        // skip current coin
        int skip = dfs(i-1,coins,amount);
        int take = 0;
        // take current coin if it is less than or equal to amount remaining
        if(amount >= coins[i]){
            take = dfs(i,coins,amount-coins[i]);
        }
        // return total numbers of ways
        return skip + take;
    }
}

// Memoization
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // memo is used to store already computed amounts
        int[][] memo = new int[n][amount+1];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }
        return dfs(n-1,coins,amount,memo);
    }
    private int dfs(int i,int[] coins,int amount,int[][] memo){
        // valid base case
        if(amount == 0){
            return 1;
        }
        // invalid base case
        if(i == -1 || amount < 0){
            return 0;
        }
        // already computed just return that
        if(memo[i][amount] != -1){
            return memo[i][amount];
        }
        // skip current coin
        int skip = dfs(i-1,coins,amount,memo);
        int take = 0;
        // take current coin if it is less than or equal to amount remaining
        if(amount >= coins[i]){
            take = dfs(i,coins,amount-coins[i],memo);
        }
        // store total ways in memo and return 
        return memo[i][amount] = skip + take;
    }
}
