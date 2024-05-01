
// Tag - Easy

// best way is to use HashSet
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) { 
        List<Integer> list = new ArrayList();
        for(List<Integer> num : nums){
            // destructure start & end points 
            int start = num.get(0);
            int end = num.get(1);
            // loop through the range add them to list
            for(int i=start; i<=end; i++){
                // check is to avoid duplicates
                if(!list.contains(i)) list.add(i);
            }
        }
        return list.size();
    }
}