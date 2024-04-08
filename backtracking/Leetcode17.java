

// Tag - Medium
class Solution {
    public List<String> letterCombinations(String digits) {
        // Initialize an empty list to store combinations
        List<String> list = new ArrayList<>();
        
        // Check for empty input
        if(digits.isEmpty() || digits == null)
            return list; 
        
        // Call backtrack method to generate combinations
        backtrack(list,"",digits);
        
        // Return the list of combinations
        return list;
    }

    private void backtrack(List<String> list,String ans,String digits){
        // Array representing letters corresponding to each digit on a phone keypad
        String[] array = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        // Base case: If no more digits left to process, add current combination to list and return
        if(digits.isEmpty()){
            list.add(ans);
            return;
        }
        
        // Extract the first digit from the remaining digits
        char ch = digits.charAt(0);
        // Calculate its corresponding index in the array
        int index = ch-'0';
        // Get the string of letters associated with the digit
        String code = array[index];

        // Iterate through each letter in the string
        for(int i=0; i<code.length(); i++){
            // Extract the current letter
            char letter = code.charAt(i);
            // Recursively call backtrack with updated combination and remaining digits
            backtrack(list,ans+letter,digits.substring(1));
        }
    }
}
