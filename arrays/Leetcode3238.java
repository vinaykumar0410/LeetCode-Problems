
// Tag - Easy

class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int cnt = 0;
        // Map to store player and their color counts
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>(); 

        // Populate the map with color counts for each player
        for(int[] p : pick) {
            int key = p[0]; // player ID
            int val = p[1]; // color chosen
            map.putIfAbsent(key, new HashMap<>());
            Map<Integer,Integer> colorCount = map.get(key);
            colorCount.put(val, colorCount.getOrDefault(val, 0) + 1);
        }

        // Check how many players have a color chosen more than their ID
        for(int i = 0; i < n; i++) {
            if(map.containsKey(i)) {
                for(int count : map.get(i).values()) {
                    if(count > i) {
                        cnt++;
                        break; 
                    }
                }
            }
        }
        return cnt; 
    }
}
