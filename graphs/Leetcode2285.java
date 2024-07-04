
// Tag - Medium
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // we have 1 to n roads
        // we have to maximize the importance
        // i have a road that connects 5 roads 
        // also i have road that connects only 2 roads 
        // so i give more imp to 5 roads connecting road then 2 roads connt
        // degree defines how many roads connected to current road
        long[] degree = new long[n];
        for(int[] road : roads){
            int startingPoint = road[0];
            int endingPoint = road[1];
            degree[startingPoint]++;
            degree[endingPoint]++;
        }
        // we have degrees of each road
        Arrays.sort(degree);
        long maximumTotalImportance = 0;
        // lets assign importance from low to high(1-5)
        long importance = 1;
        for(int i=0; i<n; i++){
            maximumTotalImportance += importance * degree[i];
            importance++;
        }
        return maximumTotalImportance;
    }
}