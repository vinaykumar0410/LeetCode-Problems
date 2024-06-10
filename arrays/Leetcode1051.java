
// Tag - Easy

class Solution {
    public int heightChecker(int[] heights) {
        // clone original heights as expected heights
        int[] expected = new int[heights.length];
        for(int i=0; i<heights.length; i++){
            expected[i] = heights[i];
        }
        // sort expected array
        Arrays.sort(expected);
        int cnt = 0;
        for(int i=0; i<heights.length; i++){
            // count distinct heights 
            if(expected[i] != heights[i]) cnt++;
        }
        return cnt;
    }
}