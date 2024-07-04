
// Tag - Medium

class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        // input array length less than or equals 4 output is always 0
        if(n <= 4) return 0;
        // Greedy one
        Arrays.sort(nums);

        // consider example 1  2  3  4  5   6  7   8   9 
        // index            0  1  2  3 ... n-4 n-3 n-2 n-1

        // case-1 (ignore last 3 elements)
        int first = nums[n-4] - nums[0]; // largest-smallest
        // case-2 (ignore first 3 elements)
        int second = nums[n-1] - nums[3];
        // case-3 (ignore first 1 & last 2 elements)
        int third = nums[n-3] - nums[1];
        // case-4 (ignore first 2 & last 1 element)
        int fourth = nums[n-2] - nums[2];

        // min of 4 differnt cases
        return Math.min(Math.min(first,second), Math.min(third,fourth));
    }
}


// can do this instead of 4 cases 
/*
 
    for(int i = 0; i < 4; i++) {
        res = Math.min(res, nums[n - 4 + i] - nums[i]);
    }

 */