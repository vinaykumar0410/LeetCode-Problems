
// Tag - Medium
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start  = Arrays.stream(bloomDay).min().getAsInt();
        int end =  Arrays.stream(bloomDay).max().getAsInt();
        int days = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isPossible(bloomDay,mid,k,m)){
                days = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return days;
    }
    private boolean isPossible(int[] bloomDay, int target, int k,int m) {
        int bouquets = 0;
        int flowers = 0;
        for (int bloomday : bloomDay) {
            if(bloomday <= target) {
                flowers++;
            }else{
                flowers = 0;
            }
            if(flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }
        return bouquets>=m;
    }
}