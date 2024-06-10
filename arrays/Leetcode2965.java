
// Tag - Easy

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet();
        // try to add every number to set
        for(int[] g : grid){
            for(int num : g){
                // unable to add (repeated value found)
                if(!set.add(num)){
                    ans[0]=num;
                } 
            } 
        } 
        // check for missed value
        int lastNumber = grid.length*grid.length;
        for(int i=1; i<=lastNumber; i++){
            if(!set.contains(i)){
                ans[1] = i;
            } 
        }
        return ans;
    }
}