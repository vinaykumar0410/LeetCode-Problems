
// Tag - Easy

// Improved Approach
class Solution {
    // Finds the intersection of two arrays.
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set to store intersecting elements.
        Set<Integer> set = new HashSet(); 
        Arrays.sort(nums1); // Sort nums1.
        Arrays.sort(nums2); // Sort nums2.
        int i = 0; // Pointer for nums1.
        int j = 0; // Pointer for nums2.
        
        // Traverse both arrays to find intersecting elements.
        while (i < nums1.length && j < nums2.length) {
            // If the elements are equal, add them to the set and move both pointers.
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            }
            // If the element in nums1 is smaller, move pointer for nums1.
            else if (nums1[i] < nums2[j]) i++;
            
            // If the element in nums2 is smaller, move pointer for nums2.
            else j++;
            
        }
        
        // Convert the set to an array.
        int[] arr = new int[set.size()]; 
        int k = 0;
        for (Integer num : set)  arr[k++] = num;
         
        return arr; // Return the array containing intersecting elements.
    }
}

/*

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList(); // List to store intersecting elements.
        Map<Integer,Integer> map = new HashMap(); // Map to store elements of nums1.
        
        // Mark elements of nums1 in the map.
        for(int num : nums1) map.put(num, 1);
        
        // Check for intersecting elements in nums2.
        for(int num : nums2) {
            // If the element exists in nums1, add it to the list and mark it as visited.
            if(map.getOrDefault(num, -1) == 1) {
                list.add(num);
                map.put(num, 0);
            }
        }
        
        // Convert the list to an array.
        int[] arr = new int[list.size()]; 
        for(int k = 0; k < list.size(); k++) arr[k] = list.get(k);
        
        return arr; // Return the array containing intersecting elements.
    }
}

*/