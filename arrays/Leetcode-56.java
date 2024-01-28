class Solution {
    public int[][] merge(int[][] intervals) {
        // return intervals if there is only one interval
        if(intervals.length <= 1) return intervals;

        // sort interval based on start interval
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));

        // don't know result array size? NP we have ArrayList
        List<int[]> mergedArray = new ArrayList();

        // keep currentInterval and add it to result
        int[] currentInterval = intervals[0];
        mergedArray.add(currentInterval);

        // loop over the input array and check if overlap exist
        for(int[] nextInterval : intervals){
            // base condition for overlapping interval
            if(currentInterval[1] >= nextInterval[0]){
                currentInterval[1] = Math.max(currentInterval[1],nextInterval[1]);
            }else{
                // over lap not found ? update  currentInterval && add it to result
                currentInterval = nextInterval;
                mergedArray.add(currentInterval);
            }
        }
        // return in normal array ? 
        return mergedArray.toArray(new int[0][]);
    }
}

/*

                                                 -------------
                       -------
     -------------
  -------
  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18

    overlap found [1,6] remaining intervals [8,10] [15,18]

           ----
  ----------
  1  2  3  4  5

    overlap found merge interval [1,5]

*/