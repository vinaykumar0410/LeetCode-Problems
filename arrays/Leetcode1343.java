
// Tag - Medium

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // basic sliding window
        // l -> left pointer, r -> right pointer
        int l = 0;
        int cnt = 0;
        int sum = 0;
        for(int r=0; r<arr.length; r++){
            // cal sum by expanding window to right
            sum += arr[r];
            // len equals k and avg greater than or equals threshold cnt it
            if(r-l+1 == k && (sum/k >= threshold)) cnt++;
            // exceeds window size of k shrink from left
            while(r-l+1 > k){
                // update sum and check condition again
                sum -= arr[l];
                l++;
                if(r-l+1 == k && (sum/k >= threshold)) cnt++;
            }
        }
        return cnt;
    }
}