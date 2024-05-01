
// Tag - Easy
class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList();
        // split non single digit to single digits
        for(int num : nums){
            char[] arr = String.valueOf(num).toCharArray();
            for(int i=0; i<arr.length; i++){
                list.add(arr[i]-'0');
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}