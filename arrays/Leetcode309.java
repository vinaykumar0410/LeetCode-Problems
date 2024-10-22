
// Tag - Medium

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // initialize memo
        int[][] memo = new int[n][2];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        // here 0 is 0th stock in prices
        // here 1 is giving chance to buy a stock
        return helper(0,1,prices,memo);
    }
    private int helper(int i,int canBuy,int[] prices,int[][] memo){
        // no more stocks to buy case
        if(i >= prices.length){
            return 0;
        }
        // already computed just use it
        if(memo[i][canBuy] != -1){
            return memo[i][canBuy];
        }
        int profit = 0;
        if(canBuy == 1){
            // can buy on current day or next day
            profit = Math.max(
                -prices[i] + helper(i+1,0,prices,memo),
                0 + helper(i+1,1,prices,memo)
            );
        }else{
            // can sell on current day or next day
            profit = Math.max(
                prices[i] + helper(i+2,1,prices,memo),
                0 + helper(i+1,0,prices,memo)
            );
        }
        // store & return computed profit
        return memo[i][canBuy] = profit;
    }
}