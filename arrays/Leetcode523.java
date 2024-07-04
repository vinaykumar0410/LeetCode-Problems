
// Tag - Medium

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // map stores remainder and its index
        Map<Integer,Integer> map = new HashMap();
        // to handle edge case
        map.put(0,-1);
        int sum = 0;
        // traverse input array
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int rem = sum%k;
            if(map.containsKey(rem)){
                // same rem found cal subarray len(should be atleast 2)
                if(i-map.get(rem) > 1){
                    return true;
                }
            }else{
                // put rem and its index
                map.put(rem,i);
            }
        }
        return false;
    }
}
