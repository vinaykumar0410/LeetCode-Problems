
// Tag - Medium
class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for(int i=1; i<prices.length; i++){
            // greater than 0 anything will be a profit
            totalProfit += Math.max(0,prices[i]-prices[i-1]);
        }
        return totalProfit;
    }
}
