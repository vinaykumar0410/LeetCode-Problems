
// Tag - Medium

class Solution {
    public int findMinDifference(List<String> timePoints) {
        // convert to mins, sort them, find min
        List<Integer> minutes = new ArrayList();
        for(String timePoint : timePoints){
            int hours = Integer.parseInt(timePoint.substring(0,2));
            int mins = Integer.parseInt(timePoint.substring(3,5));
            minutes.add(hours*60 + mins);
        } 
        Collections.sort(minutes);
        // take out min from consective indices
        int n = minutes.size();
        int ans = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            ans = Math.min(ans,minutes.get(i)-minutes.get(i-1));
        }
        // may be anti close wise can get a min
        int antiClockmin = (24*60) - (minutes.get(n-1)-minutes.get(0));
        return Math.min(ans, antiClockmin);
    }
}