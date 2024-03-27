
// Tag - Medium

// TC - O(n)
// SC - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        // Create a boolean array to mark visited elements.
        boolean[] vis = new boolean[nums.length];
        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // If the element is already visited, it's a duplicate.
            if (vis[nums[i]])
                return nums[i];
            vis[nums[i]] = true;
        }
        // If no duplicate is found, return 100 (arbitrary value).
        return 100;
    }
}


/*
// TC - O(n)
// SC - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Move slow pointer by one step and fast pointer by two steps until they meet.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Reset fast pointer to the start and move both pointers by one step until they meet.
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        // Return the duplicate number found by both pointers.
        return slow;
    }
}
*/


/*
// TC - O(nlogn)
// SC - O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        // Sort the array.
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        // Iterate through the sorted array.
        while (j < nums.length) {
            // If adjacent elements are equal, it's a duplicate.
            if (nums[i] == nums[j])
                return nums[j];
            i++;
            j++;
        }
        // If no duplicate is found, return 100 (arbitrary value).
        return 100;
    }
}
*/


/*
// TC - O(n)
// SC - O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        // Create a HashMap to store the frequency of each element.
        Map<Integer, Integer> map = new HashMap();
        // Iterate through the array.
        for (int num : nums) {
            // Update the frequency of the element in the map.
            map.put(num, map.getOrDefault(num, 0) + 1);
            // If the frequency becomes more than 1, it's a duplicate.
            if (map.get(num) != 1)
                return num;
        } 
        // If no duplicate is found, return 0.
        return 0;
    }
}
*/


/*
// TC - O(n)
// SC - O(n)
class Solution {
    public int findDuplicate(int[] nums) {
        // Create a HashSet to store visited elements.
        HashSet<Integer> set = new HashSet();
        // Iterate through the array.
        for (int num : nums) {
            // If the element is already in the set, it's a duplicate.
            if (!set.add(num))
                return num;
        } 
        // If no duplicate is found, return 0.
        return 0;
    }
}
*/
