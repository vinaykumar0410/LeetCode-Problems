
// Tag - Easy
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0; // Pointer for nums1.
        int j = 0; // Pointer for nums2.
        
        // Traverse both arrays until reaching the end of either array.
        while (i < nums1.length && j < nums2.length) {
            // If a common element is found, return it.
            if (nums1[i] == nums2[j]) return nums1[i];
            
            // Move pointer for nums1 if its current element is smaller.
            if (nums1[i] < nums2[j]) i++;
            
            // Move pointer for nums2 if its current element is smaller.
            else j++;
            
        }
        
        return -1; // Return -1 if no common element is found.
    }
}
