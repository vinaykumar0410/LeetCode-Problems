
// Tag - Easy

// TC - O(max(n,m))
// SC - O(n)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        Map<Integer,Integer> map = new HashMap();
        for(int num : nums1){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // {1:2,2:2}
        for(int num : nums2){
            if(map.getOrDefault(num,-1) > 0){
                list.add(num);
                map.put(num,map.get(num)-1);
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}

// TC - O(max(n,m))
// SC - O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        int[] freq = new int[1001];
        for(int num : nums1){
            freq[num]++;
        }
        for(int num : nums2){
            if(freq[num] > 0){
                list.add(num);
                freq[num]--;
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}