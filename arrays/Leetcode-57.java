import java.util.ArrayList;
import java.util.List;

// Tag - Medium
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // add all intervals before overlap exists condition -> intervals end < newInterval start
        while(i<n && intervals[i][1] < newInterval[0]){ 
            list.add(intervals[i++]);
        }

        // add interval at overlap condition -> intervals start < newInterval end
        while(i<n && intervals[i][0] <= newInterval[1]){ 
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        // add remaining intervals
        while(i < n){
            list.add(intervals[i++]);
        }

        // return list in array
        return list.toArray(new int[list.size()][]);
    }
}
