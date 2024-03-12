
// Tag - Easy

// Improved Approach
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101]; // Array to store frequency of elements (since nums[i] ranges from 1 to 100).
        // Calculate the frequency of each element.
        for(int num : nums) freq[num]++;
        
        int max = 0; // Maximum frequency found.
        int cnt = 0; // Count of elements having maximum frequency.

        // Find the maximum frequency.
        for(int value : freq) {
            if(value > max) {
                max = value;
            }
        }

        // Count the elements having maximum frequency.
        for(int value : freq) {
            if(value == max) {
                cnt++;
            }
        }
        
        return max * cnt; // Return the product of maximum frequency and count.
    }
}

/*
// Brute force Approach:

class Solution {
    public int maxFrequencyElements(int[] nums) {
        // Map to store frequency of each element.
        Map<Integer,Integer> map = new HashMap(); 

        // Calculate the frequency of each element.
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0; // Maximum frequency found.
        int cnt = 0; // Count of elements having maximum frequency.

        // Find the maximum frequency.
        for(int key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
            }
        }

        // Count the elements having maximum frequency.
        for(int key : map.keySet()) {
            if(map.get(key) == max) {
                cnt++;
            }
        }
        return max * cnt; // Return the product of maximum frequency and count.
    }
}
*/
