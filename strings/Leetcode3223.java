
// Tag - Medium
class Solution {
    public int minimumLength(String s) {
        int ans = s.length();
        Map<Character,Integer> map = new HashMap();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
            // found 3
            if(map.get(ch) > 2){
                // keep 1 (assume u are deleting left and right)
                map.put(ch,1);
                // reduce length by 2
                ans -= 2;
            }
        }
        return ans;
    }
}