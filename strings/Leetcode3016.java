
// Tag - Medium

class Solution {
    public int minimumPushes(String word) {
        int ans = 0;
        int[] freq = new int[26];
        // take out freqency of each char
        for(char ch : word.toCharArray()){
            freq[ch-'a']++;
        }
        // max heap holds high priority values first
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(b,a)
        );
        // add all freqs to priority queue
        for(int fr : freq){
            pq.offer(fr);
        }
        int cnt = 0;
        int multiplier = 1;
        // loop until priority queue becomes becomes empty
        while(!pq.isEmpty()){
            int fr = pq.poll();
            // process only non zero frequency
            if(fr != 0){
                // count becomes 8 meaning done with 1st chars
                if(cnt == 8){
                    // increment multiplier for 2nd chars
                    multiplier++;
                    // reset count
                    cnt = 0;
                }
                // count & calculate no of taps
                cnt++;
                ans += fr*multiplier;
            }
        }
        return ans;
    }
}