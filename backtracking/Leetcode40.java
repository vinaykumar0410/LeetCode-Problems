
// Tag - Medium

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // sort to eliminate duplicates easily
        Arrays.sort(candidates); 
        backtrack(ans,candidates,target,new ArrayList<>(),0);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,int[] candidates, int target, List<Integer> list, int start){
        // invalid case
        if(target < 0){
            return;
        }else if(target == 0){ // valid case
            ans.add(new ArrayList<>(list));
            return;
        }else{
            // backtracking
            for(int i=start; i<candidates.length; i++){
                if(i != start && candidates[i-1] == candidates[i]){
                    continue;
                }
                // taking
                list.add(candidates[i]);
                backtrack(ans,candidates,target-candidates[i],list,i+1);
                // skiping
                list.remove(list.size()-1);
            }
        }
    }
}