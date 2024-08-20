
// Tag - Medium

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // init ans list
        List<List<Integer>> ans = new ArrayList();
        // backtrack
        backtrack(ans,new ArrayList<>(),k,n,1);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, List<Integer> list,int k,int remain,int start){
        if(list.size() > k){ // list size exceeds k (invalid case)
            return;
        }else if(list.size() == k && remain == 0){
            // list size equals k & sum up to n found valid list
            ans.add(new ArrayList<>(list));
        }else{
            for(int i=start; i<=9; i++){
                // add current element 
                list.add(i);
                // backtrack for next element don't forget to reduce remain
                backtrack(ans,list,k,remain-i,i+1);
                // try another possibility by removing last added element
                list.remove(list.size()-1);
            }
        }
    }
}