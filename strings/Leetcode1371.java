
// Tag - Medium

// prefix sum LC-525
// prefix xor LC-1371
class Solution {
    public int findTheLongestSubstring(String s) {
        int ans = 0;
        int xor = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,-1);
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // found vowel xor that
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                xor ^= ch;
            }
            // else check if it contains then calcuate length else store it
            if(map.containsKey(xor)){
                ans = Math.max(ans,i-map.get(xor));
            }else{
                map.put(xor,i);
            }
        }
        return ans;
    }
}