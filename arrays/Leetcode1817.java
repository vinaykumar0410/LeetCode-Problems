
// Tag - Medium

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        // store {id:min}
        Map<Integer,Set<Integer>> map = new HashMap();
        for(int[] log : logs){
            int id = log[0];
            int min = log[1];
            if(!map.containsKey(id)) map.put(id,new HashSet());
            map.get(id).add(min);  
        }
        for(int key : map.keySet()){
            int index = map.get(key).size();
            // i thought it was ans[index-1] = index 
            ans[index-1]++;
        }
        return ans;
    }
}