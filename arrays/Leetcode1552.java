
// Tag - Medium
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int ans = 0;
        int start = 1;
        int end = position[n-1] - position[0];
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isPossible(position,mid,m,n)){
                start = mid+1;
                ans = mid;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] position,int minDistance,int m,int n){
        int lastBallPlaced = position[0];
        int ballsPlaced = 1;
        for(int i=1; i<n; i++){
            if(position[i]-lastBallPlaced >= minDistance){
                ballsPlaced++;
                lastBallPlaced = position[i];
            }
        }
        return ballsPlaced >= m;
    }
}