
// Tag - Medium

class Solution {
    public int minGroups(int[][] intervals) {
        // convert intervals to events (+1 for start and -1 for end)
        List<int[]> events = new ArrayList();
        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1]+1;
            events.add(new int[]{start,1});
            events.add(new int[]{end,-1});
        }
        // sort events by start time
        Collections.sort(events,(a,b)->{
            // if start time is same sort by end time
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        // find max concurrent intervals
        int maxConcurrentIntervals = 0;
        int concurrentIntervals = 0;
        // traverse events 
        for(int[] event : events){
            // update concurrent intervals and max concurrent intervals
            concurrentIntervals += event[1];
            maxConcurrentIntervals = Math.max(maxConcurrentIntervals,concurrentIntervals);
        }
        return maxConcurrentIntervals;
    }
}