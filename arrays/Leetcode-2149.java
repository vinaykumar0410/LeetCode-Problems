
// Tag - Medium
class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Initialize an array to store the rearranged elements.
        int[] arr = new int[nums.length];
        
        // Pointer for even indices to place positive numbers.
        int p = 0;
        
        // Pointer for odd indices to place negative numbers.
        int n = 1;
        
        // Traverse the input array.
        for(int i = 0; i < nums.length; i++) {
            // Place positive numbers at even indices.
            if(nums[i] > 0) {
                arr[p] = nums[i];
                p += 2;
            }
            // Place negative numbers at odd indices.
            else {
                arr[n] = nums[i];
                n += 2;
            }
        }
        
        // Return the rearranged array.
        return arr;
    }
}

/*
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int[] pos = new int[nums.length/2];
        int[] neg = new int[nums.length/2];
        int i = 0;
        int j = 0;
        for(int num : nums){
            if(num < 0) neg[i++] = num;
            else pos[j++] = num;
        }
        i = 0;
        j = 0;
        for(int k=0; k<nums.length; k++){
            if(k%2==0) res[k] = pos[i++];
            else res[k] = neg[j++];
        }
        return res;
    }
}
*/