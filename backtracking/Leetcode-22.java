
// Tag - Medium
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        // Initialize an empty list to store valid combinations
        List<String> list = new ArrayList<>();

        // Call backtrack method to generate combinations recursively
        backtrack(list, "", 0, 0, n);

        // Return the list of valid combinations
        return list;
    }

    private void backtrack(List<String> list, String item, int open, int close, int n) {
        // Base case: If the length of the current combination equals 2*n (balanced parentheses),
        // add it to the list of valid combinations and return
        if (item.length() == n * 2) {
            list.add(item);
            return;
        }

        // If the count of opening parentheses is less than n, add an opening parenthesis and backtrack
        if (open < n) {
            backtrack(list, item + "(", open + 1, close, n);
        }

        // If the count of closing parentheses is less than the count of opening parentheses,
        // add a closing parenthesis and backtrack
        if (close < open) {
            backtrack(list, item + ")", open, close + 1, n);
        }
    }
}
