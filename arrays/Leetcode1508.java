
// Tag - Medium

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // init sums array to store all subarray sums
        int[] sums = new int[n * (n + 1) / 2]; 
        int k = 0;

        // Calculate all possible subarray sums and store in sums array
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                // Store each subarray sum
                sums[k++] = sum; 
            }
        }
        
        System.out.println(Arrays.toString(sums)); 
        // Sort the sums array
        Arrays.sort(sums); 

        long ans = 0;
        // Modulus value to avoid overflow
        int mod = 1000_000_007; 

        // Sum the elements from index `left-1` to `right-1` in the sorted sums array
        for(int i = left - 1; i < right; i++){
            ans += sums[i];
        }

        // Mod the answer if it exceeds the integer limit
        if(ans > Integer.MAX_VALUE){
            ans = ans % mod;
        }

        // Return the result as an integer
        return (int) ans; 
    }
}
