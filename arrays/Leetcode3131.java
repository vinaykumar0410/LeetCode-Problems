
// Tag - Easy
class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        // problem looks like greedy just sort them
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // here we need to find that val which is add to make two array vals same
        return nums2[0]-nums1[0];
    }
}