
// Tag - Medium

// TC - O(n)
// SC - O(n)
class Solution {
    public int[] singleNumber(int[] nums) {
        int[] array = new int[2];
        int index = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        } 
        for(int key : map.keySet()){
            if(map.get(key)==1) array[index++] = key;
        }
        return array;
    }
}