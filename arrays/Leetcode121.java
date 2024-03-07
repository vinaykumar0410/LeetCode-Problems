
// Tag - Easy
class Solution {
    public int maxProfit(int[] prices) {
        // keep track of min price and update max profit
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            // update min price
            minPrice = Math.min(minPrice,prices[i]);
            // calculate current profit
            int currentProfit = prices[i] - minPrice;
            // update max profit
            maxProfit = Math.max(maxProfit,currentProfit);
        }
        return maxProfit;
    }
}
