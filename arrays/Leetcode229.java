
// Tag - Medium

// TC - O(n^2)
// SC - O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList();
        // traversed array n^2 times
        // check whether it is more than n/3 or not
        for(int i=0; i<nums.length; i++){
            int count = 1;
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(list.contains(nums[i]))continue;
            else if(count > nums.length/3) list.add(nums[i]);
        }
        return list;
    }
}

// TC - O(n)
// Sc - O(n)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList();
        Map<Integer,Integer> map = new HashMap();
        // traversed array once and cnt each number frequency
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key) > nums.length/3) list.add(key);
        }
        return list;
    }
}

// follow up question in O(1) space
// here im maintaining map with atmost size 3 which is equivalent to O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // list holds values occured more than n/3 times
        List<Integer> list = new ArrayList();
        // map keeps track of top 2 most frequent elements
        Map<Integer,Integer> map = new HashMap();
        // traverse input array & calculate frequency of each element
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            // map size reached 3 shrink it by reducing each freq by one
            if(map.size() > 2){
                Map<Integer,Integer> newMap = new HashMap();
                for(int key : map.keySet()){
                    // consider only elements with freq more than 1
                    // bcoz we don't care about 0 frequency elements 
                    if(map.get(key) > 1){
                        newMap.put(key,map.get(key)-1);
                    }
                }
                // assign new map to old map
                map = newMap;
            }
        }
        // cross verify whether top 2 frequent elements actually 
        // repeated more than n/3 times or not
        for(int key : map.keySet()){
            int cnt = getCount(nums, key);
            // more than n/3 found one of the answer
            if(cnt > nums.length/3){
                list.add(key);
            }
        }
        return list;
    }
    // method to count occurence of an element in an array
    private int getCount(int[] nums, int target){
        int cnt = 0;
        for(int num : nums){
            if(num == target){
                cnt++;
            }
        }
        return cnt;
    }
}
