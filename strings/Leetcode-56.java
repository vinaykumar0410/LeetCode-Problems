
// Tag - Medium
class Solution {
    public int[][] merge(int[][] intervals) {

        // sort the given array based on start interval
        Arrays.sort(intervals,(interval1,interval2)->Integer.compare(interval1[0],interval2[0]));

        // don't know resultant array size ? we have arraylist
        List<int[]> mergedArray = new ArrayList();

        // store current interval and add to mergedArray
        int[] currentInterval = intervals[0];
        mergedArray.add(currentInterval);

        // traverse input array
        for(int[] nextInterval : intervals){

            // check if over lap exists if so update currentInterval
            if(currentInterval[1] >= nextInterval[0]){
                currentInterval[1] = Math.max(currentInterval[1],nextInterval[1]);
            }else{
            // if overlap doesn't exist np add it to mergedArray
            currentInterval = nextInterval;
            mergedArray.add(currentInterval);
            }
        }
        
        // done we have merged intervals in list convert that
        return mergedArray.toArray(new int[mergedArray.size()][]); 
    }
}


