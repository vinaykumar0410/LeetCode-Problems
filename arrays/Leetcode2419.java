
// Tag - Medium

class Solution {
    public int longestSubarray(int[] nums) {
        // count consective maximums
        int ans = 0;
        int max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        } 
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == max){
                cnt++;
            }else{
                cnt = 0;
            }
            ans = Math.max(ans,cnt);
        }
        return ans;
    }
}