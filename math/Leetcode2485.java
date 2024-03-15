
// Tag - Easy
class Solution {
    public int pivotInteger(int n) {
        // Calculate total sum of the sequence
        int totalSum = n*(n+1)/2;
        int leftSum = 0; // Initialize left sum
        
        // Iterate through the sequence
        for (int i = 1; i <= n; i++) {
            // Update left sum
            leftSum += i; 
            
            // Check if current element is pivot integer
            if (leftSum - i == totalSum - leftSum) {
                // Return pivot integer
                return i; 
            }
        }
        return -1; // No pivot integer found
    }
}
