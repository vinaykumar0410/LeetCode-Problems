
// Tag - Medium

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // list is used to store all angarams
        List<Integer> list = new ArrayList();
        // pCount is the target anagram freq
        int[] pCount = new int[26];
        for(char ch : p.toCharArray()){
            pCount[ch-'a']++;
        } 
        // l is left pointer of sliding window
        int l = 0;
        // sCount is the curr anagram freq
        int[] sCount = new int[26];
        for(int r=0; r<s.length(); r++){
            // cal freq expanding window to the right
            char rightChar = s.charAt(r);
            sCount[rightChar-'a']++;
            // check if curr freq and target freq matches
            if(isAnagram(pCount,sCount)){
                list.add(l);
            } 
            // if exceeds anagram length shrink window from left
            while(r-l+1 > p.length()){
                // cal freq and check again for freq matching
                char leftChar = s.charAt(l++);
                sCount[leftChar-'a']--;
                if(isAnagram(pCount,sCount)){
                    list.add(l);
                } 
            }
        }
        return list;
    }
    // method to check where two array freq equal or not
    private boolean isAnagram(int[] a,int[] b){
        boolean found = true;
        for(int i=0; i<26; i++){
            if(a[i] != b[i]){
                found = false;
            } 
        } 
        return found;
    }
}