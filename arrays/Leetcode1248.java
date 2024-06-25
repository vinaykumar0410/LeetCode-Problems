
// Tag - Medium
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // pre-computution
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]%2==0 ? 0 : 1;
        }
        int cnt = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum-k)){
                cnt += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}