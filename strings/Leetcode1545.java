
// Tag - Medium

class Solution {
    public char findKthBit(int n, int k) {
        String sn = helper(1,n,"0");
        return sn.charAt(k-1);
    }
    private String helper(int i,int n,String curr){
        // base case
        if(i == n){
            return curr;
        }
        // 
        StringBuilder sb = new StringBuilder(curr);
        sb.append("1");
        // traverse from end to start & compliment each character 
        for(int j=curr.length()-1; j>=0; j--){
            sb.append(curr.charAt(j)=='0' ? '1' : '0');
        }
        // recursively call for next index
        return helper(i+1,n,sb.toString());
    }
}
