
// Tag - Medium
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Initialize a list to store all valid combinations
        List<List<Integer>> list = new ArrayList<>();

        // Call backtrack method to find combinations recursively
        backtrack(list, candidates, 0, new ArrayList<>(), target);

        // Return the list of valid combinations
        return list;
    }
    
    private void backtrack(List<List<Integer>> list, int[] candidates, int index, List<Integer> tempList, int target) {
        // Base case: If we've exhausted all candidates, check if target is achieved
        if (index == candidates.length) {
            if (target == 0) {
                // If target is achieved, add current combination to the list
                list.add(new ArrayList<>(tempList));
            }
            return;
        }

        // Recursive case:
        // 1. Include the current candidate in the combination if it doesn't exceed the target
        if (candidates[index] <= target) {
            tempList.add(candidates[index]); // Add current candidate to the combination
            // Recur with the same candidate index and updated target
            backtrack(list, candidates, index, tempList, target - candidates[index]);
            tempList.remove(tempList.size() - 1); // Backtrack: remove the added candidate from combination
        }
        
        // 2. Skip the current candidate and move to the next one
        backtrack(list, candidates, index + 1, tempList, target);
    }
}
