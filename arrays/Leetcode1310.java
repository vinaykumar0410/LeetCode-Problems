
// Tag - Medium

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int index = 0;
        // traverse input queries & xor all the elements from start to end in specific query
        for(int[] query : queries){
            int start = query[0];
            int end = query[1];
            int xor = arr[start];
            for(int i=start+1; i<=end; i++){
                xor ^= arr[i];
            }
            // assign to ans array
            ans[index++] = xor;
        }
        return ans;
    }
}