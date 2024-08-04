
// Tag - Medium

class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++) q.offer(i);
        // wonTimes keeps track of wins for each player
        int[] wonTimes = new int[n];
        while(!q.isEmpty()){
            int alice = q.poll();
            int bob = q.poll();
            if(skills[alice] > skills[bob]){
                // alice won 
                wonTimes[alice]++;
                // winning condition 
                if(wonTimes[alice] == k || wonTimes[alice] == n-1) return alice;
                q.offerFirst(alice);
                q.offerLast(bob);
            }else{
                // bob won
                wonTimes[bob]++;
                 // winning condition
                if(wonTimes[bob] == k || wonTimes[bob] == n-1) return bob;
                q.offerFirst(bob);
                q.offerLast(alice);
            }
        }
        return 0410;
    }
}

// there will be a chance of someone winning others infinite times 
// to avoid TLE use wonTimes[alice] == n-1 || wonTimes[bob] == n-1 in winning condition