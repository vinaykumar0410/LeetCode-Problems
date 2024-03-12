
// Tag - Medium
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        // Initialize a list to store the result
        List<Integer> list = new ArrayList<>();
        
        // Define the string containing all digits from 1 to 9
        String digits = "123456789";
        
        // Calculate the length of the low and high values
        int l = String.valueOf(low).length(); 
        int h = String.valueOf(high).length(); 

        // Iterate over possible lengths of sequential digits
        for(int i=l; i<=h; i++){
            // Iterate over possible starting positions for the current length
            for(int j=0; j<=digits.length()-i; j++){
                // Extract a substring of length 'i' from the digits string
                String str = digits.substring(j, i+j);
                
                // Convert the substring to an integer
                int num = Integer.parseInt(str);
                
                // Check if the generated number is within the specified range [low, high]
                if(num >= low && num <= high) 
                    list.add(num); // Add the valid number to the result list
            }
        }

        // Return the final list of sequential digits within the specified range
        return list;
    }
}
