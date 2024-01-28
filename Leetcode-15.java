
// Tag - Medium
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort array 
        Arrays.sort(nums);
        // initialize a list of hashset which holds unique triplets
        Set<List<Integer>> set = new HashSet();
        // traverse input array with i pointer
        for(int i=0; i<nums.length-2; i++){
            // initialize j pointer one step ahead of i
            int j = i+1;
            // initialize k pointer at last index
            int k = nums.length-1;
            // loop until j less than k
            while(j < k){
                // calulate sum of 3 pointers
                int sum = nums[i] + nums[j] + nums[k];
                // if sum becomes 0 triplet found add to set and move pointers
                if(sum == 0){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));  
                    j++; 
                    k--;
                }
                // if sum less than 0 (need big number which lie on right side so move j pointer)
                else if(sum < 0) j++;
                // if sum greater than 0 (need small number which lie on left side so move k pointer)
                else if(sum > 0) k--;
            }
        }
        // convert set to list
        return new ArrayList(set);
    }
}