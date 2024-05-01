
// Tag - Easy
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        // sum first k elements
        for(int i=0; i<k; i++) sum += nums[i];
        // max holds max sum of k elements
        int max = sum;
        int start = 0;
        // iterate from k to end of nums
        for(int end = k; end < nums.length; end++){
            // look forward for better max sum
            sum = sum - nums[start] + nums[end]; 
            max = Math.max(max, sum); 
            start++; 
        }
        // hope everyone know avg formula (sum of elements/no of elements)
        return (double)max/k;
    }
}