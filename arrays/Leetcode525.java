
// Tag - Medium

class Solution {
    public int findMaxLength(int[] nums) {
        // Variable to store the maximum length of the subarray.
        int maxLength = 0;
        // Map to store the sum and its corresponding index.
        Map<Integer,Integer> map = new HashMap();
        // Initial sum and index value.
        map.put(0,-1);
        int sum = 0;
        // Loop through the array.
        for(int i=0; i<nums.length; i++){
            // Update the sum based on the current element.
            if(nums[i]==0) sum--;
            else sum++;
            // If the sum exists in the map, update the maxLength.
            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength,i-map.get(sum));
            }else{
                // If the sum is not present, add it to the map.
                map.put(sum,i);
            }
        }
        return maxLength; // Return the maximum length.
    }
}


/*
// TLE
class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        for(int i=0; i<nums.length; i++){
            int zeroCount = 0;
            int onesCount = 0;
            for(int j=i; j<nums.length; j++){
                if(nums[j] == 0){
                    zeroCount++;
                }else{
                    onesCount++;
                }
                if(zeroCount == onesCount){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
        }
        return maxLength;
    }
}
*/
