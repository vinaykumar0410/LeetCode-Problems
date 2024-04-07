
// Tag - Easy
import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>(); // Initialize the result list
        List<Integer> l1 = new ArrayList<>(); // List to store elements unique to nums1
        List<Integer> l2 = new ArrayList<>(); // List to store elements unique to nums2
        Set<Integer> first = new HashSet<>(); // Set to store elements of nums1
        Set<Integer> second = new HashSet<>(); // Set to store elements of nums2
        
        // Add elements of nums1 to the first set
        for (int num : nums1) {
            first.add(num);
        }
        
        // Add elements of nums2 to the second set
        for (int num : nums2) {
            second.add(num);
        }
        
        // Find elements in nums1 that are not in nums2 and add them to l1
        for (int num : nums1) {
            if (!second.contains(num) && !l1.contains(num)) {
                l1.add(num);
            }
        }
        
        // Find elements in nums2 that are not in nums1 and add them to l2
        for (int num : nums2) {
            if (!first.contains(num) && !l2.contains(num)) {
                l2.add(num);
            }
        }
        
        list.add(l1); // Add l1 to the result list
        list.add(l2); // Add l2 to the result list
        return list; // Return the result list
    }
}
