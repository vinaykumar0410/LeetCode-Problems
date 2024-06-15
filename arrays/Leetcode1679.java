
// Tag - Medium

class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        // two pointer
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            int sum = nums[i] + nums[j];
            // count when sum equals k and increment decrement pointers
            if(sum == k){
                cnt++;
                i++;
                j--;
            }else if(sum < k){
                // need more move i pointer
                i++;
            }else{
                // need less move j pointer
                j--;
            }
        }
        return cnt;
    }
}
// 1 3 3 3 4