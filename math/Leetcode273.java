
// Tag - Hard

class Solution {
    // Arrays to map numeric values to their corresponding English words
    final int[] nums = {1000_000_000, 1000_000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    final String[] strs = {"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};

    public String numberToWords(int num) {
        // Special case: handle zero explicitly
        if (num == 0) {
            return "Zero"; 
        }

        StringBuilder ans = new StringBuilder();

        // Convert the number to its word representation
        for (int i = 0; i < nums.length; i++) {
            // Find the largest denomination that fits into num
            if (num >= nums[i]) { 
                // Determine how many times the denomination fits
                int cnt = num / nums[i]; 
                // Reduce num by the denomination amount
                num %= nums[i]; 

                // If the denomination is 100 or larger, convert the quotient recursively
                if (nums[i] >= 100) {
                    ans.append(numberToWords(cnt)).append(" ").append(strs[i]).append(" ");
                } else {
                    // For smaller denominations, append the word directly
                    ans.append(strs[i]).append(" "); 
                }
            }
        }
        // Remove any trailing spaces and return the result
        return ans.toString().trim(); 
    }
}
