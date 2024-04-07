
// Tag - Medium
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Minimum possible eating speed
        int left = 1; 
        // Maximum possible eating speed given in constraints
        int right = 10000_00000; // 10^9
        
        // Binary search to find the minimum eating speed
        while (left < right) {
            // Calculate mid eating speed
            int mid = left + (right - left) / 2; 
            if (kokoCanEatInTime(piles, mid, h)) {
                // If Koko can eat all bananas in time with current eating speed, search left
                // why left need to search for less time which lie on left
                right = mid;
            } else {
                // If Koko cannot eat all bananas in time with current eating speed, search right
                left = mid + 1;
            }
        }
        // Return the minimum eating speed
        return left; 
    }
    
    // Function to check if Koko can eat all bananas in time with a given eating speed
    boolean kokoCanEatInTime(int[] piles, int speed, int h) {
        // Total hours Koko needs to eat all bananas
        int hours = 0; 
        
        // Calculate total hours needed to eat all bananas with given speed
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed; // Round up division to get hours needed for each pile
        }
        
        return hours <= h; // Check if total hours is less than or equal to available time
    }
}
