
// Tag - Medium

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for(int i=0; i<n; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        // custom sort
        Arrays.sort(strs,(a,b)->(b+a).compareTo(a+b));
        StringBuilder ans = new StringBuilder();
        for(String str : strs){
            ans.append(str);
        }
        return ans.toString().startsWith("0") ? "0" : ans.toString();
    }
}