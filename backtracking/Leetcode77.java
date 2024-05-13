
// Tag - Medium
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // Initialize a list to store the combinations.
        List<List<Integer>> result = new ArrayList();
        
        // Perform backtracking to generate combinations.
        backtrack(result, 1, n, k, new ArrayList());
        
        // Return the list of combinations.
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, int start, int n, int k, List<Integer> tempList) {
        // If the current combination is of size k, add it to the result.
        if (tempList.size() == k) {
            result.add(new ArrayList(tempList));
            return;
        }
        
        // Generate combinations recursively.
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(result, i + 1, n, k, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
