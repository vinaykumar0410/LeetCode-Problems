
// Tag - Medium
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        int sum = 0;
        for(int num : nums){
            sum += num;
            int rem= sum%k;
            if(rem < 0){
                rem += k;
            }
            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return cnt;
    }
}