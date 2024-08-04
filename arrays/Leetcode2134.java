
// Tag - Medium

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        // calculate 1's count
        int total = 0;
        for(int num : nums) if(num == 1) total++;
        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        int l = 0;
        // sliding window approach
        for(int r=0; r<n*2; r++){
            // % helps to map respective index in nums
            if(nums[r%n] == 1) cnt++;
            // if window size exceeds total shrink window from left
            if(r-l+1 > total){
                if(nums[l%n] == 1) cnt--;
                l++;
            }
            // calculate min swaps
            ans = Math.min(ans,total-cnt);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

// TC - O(n)
// SC - O(n^2)
class Solution {
    public int minSwaps(int[] nums) {
        // can take array twice for making it circular in nature
        int[] extra = new int[nums.length*2];
        for(int i=0; i<nums.length; i++){
            extra[i] = nums[i];
            extra[i+nums.length] = nums[i];
        }
        // take out total count of 1's
        int total = 0;
        for(int num : nums){
            if(num == 1){
                total++;
            }
        }
        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        int l = 0;
        // sliding window approach
        for(int r=0; r<extra.length; r++){
            // found 1 increment cnt
            if(extra[r] == 1){
                cnt++;
            }
            // if window size exceeds total shrink window from left
            if(r-l+1 > total){
                if(extra[l] == 1){
                    cnt--;
                }
                l++;
            }
            // calculate min swaps 
            ans = Math.min(ans,total-cnt);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
