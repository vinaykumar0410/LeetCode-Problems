
// Tag - Easy

class Solution {
    public int minOperations(String[] logs) {
        int cnt = 0;
        for(String log : logs){
            // found ../ move back one dir only if cnt is not 0
            if(log.equals("../") && cnt != 0){
                cnt--;
            }else if(log.equals("./") || log.equals("../") && cnt == 0){
                continue;
            }else{
                cnt++;
            } 
        }
        return cnt<0 ? 0 : cnt;
    }
}