
// Tag - Hard

class Solution {
    public int trap(int[] height) {
        // Initialize start pointer & end pointer
        int start = 0; 
        int end = height.length-1; 
        // Initialize left maximum height & right maximum height
        int leftMax = 0; 
        int rightMax = 0; 
        // Initialize total trapped rainwater
        int max = 0; 
        
        // Iterate through the array using two pointers
        while(start <= end){
            // Update left maximum height
            leftMax = Math.max(leftMax,height[start]);
            // Update right maximum height
            rightMax = Math.max(rightMax,height[end]);
            
            // If left maximum height is less than right maximum height
            if(leftMax < rightMax){
                // Calculate the amount of water trapped at start pointer position
                max += leftMax - height[start];
                // Move start pointer to the right
                start++;
            } else { // If left maximum height is greater than or equal to right maximum height
                // Calculate the amount of water trapped at end pointer position
                max += rightMax - height[end];
                // Move end pointer to the left
                end--;
            }
        }
        // Return total trapped rainwater
        return max;
    }
}

/*

class Solution {
    public int trap(int[] height) {
        // Array to store maximum height from left
        int[] left = new int[height.length]; 
        // Array to store maximum height from right
        int[] right = new int[height.length]; 
        
        // Initialize the leftmost bar
        left[0] = height[0]; 
        // Initialize the rightmost bar
        right[right.length-1] = height[height.length-1]; 
        
        // Calculate maximum height of bars from left
        for(int i=1; i<height.length; i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        
        // Calculate maximum height of bars from right
        for(int i=height.length-2; i>=0; i--){
            right[i] = Math.max(right[i+1], height[i]);
        }
        
        // Initialize units of trapped rainwater
        int units = 0; 
        
        // Calculate the amount of water trapped above each bar
        for(int i=0; i<height.length; i++){
            units += Math.min(left[i], right[i]) - height[i];
        }
        
        // Return total units of trapped rainwater
        return units; 
    }
}

*/