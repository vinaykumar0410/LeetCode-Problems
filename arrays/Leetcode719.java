
// Tag - Hard

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int minDistance = 0;
        int maxDistance = nums[nums.length-1]-nums[0];
        // Binary search to find the k-th smallest distance
        while (minDistance < maxDistance) {
            int midDistance = minDistance + (maxDistance - minDistance) / 2;
            int pairCount = countPairs(nums, midDistance);
            if(pairCount >= k) {
                // Narrow the search range
                maxDistance = midDistance;
            }else{
                minDistance = midDistance+1;
            }
        }
        // The k-th smallest distance
        return minDistance; 
    }
    // Count the number of pairs with a distance less than or equal to targetDistance
    private int countPairs(int[] nums, int targetDistance) {
        int pairCount = 0;
        int l = 0;
        // Use two pointers to count valid pairs
        for(int r=1; r<nums.length; r++) {
            while(nums[r]-nums[l] > targetDistance) {
                l++;
            }
            // Add the number of valid pairs
            pairCount += r - l; 
        }
        
        return pairCount;
    }
}
