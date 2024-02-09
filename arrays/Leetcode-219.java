
// Tag - Easy

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasNearbyDuplicate(int[] nums, int k) {

        // Map to store the last occurrence index of each number.
        Map<Integer,Integer> map = new HashMap<>();

        // keeps track of duplicate found or not
        boolean found = false;

        // Iterate through the array.
        for(int i = 0; i < nums.length; i++) {
            // Check if the current number is already in the map.
            if(map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k)
                found = true;
            // Update the index of the current number in the map.
            map.put(nums[i], i);
        }

        return found;
    }
}
