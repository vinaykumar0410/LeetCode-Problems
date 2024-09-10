
// Tag - Medium

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        /*
            sum of observations
            -------------------   = mean  -> (sum of obs = no of obs * mean)
            no of observations

        */
        int m = rolls.length;
        int noOfObservations = m+n;
        int sumOfObservations = noOfObservations * mean;

        int rollSum = 0;
        for(int roll : rolls) rollSum += roll;
        int missingSum = sumOfObservations - rollSum;

        // unable to populate return empty list
        if(missingSum < n || missingSum > 6*n){
            return new int[0];
        }

        // init n size array
        int[] ans = new int[n];
        // time to populate missingSum to n places that satisfies the formula
        for(int i=0; i<n; i++){
            ans[i] = Math.min(6, missingSum-(n-i-1));
            missingSum -= ans[i];
        }
        return ans;
    }
}