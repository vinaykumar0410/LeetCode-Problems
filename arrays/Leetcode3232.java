
// Tag - Easy

class Solution {
    public boolean canAliceWin(int[] nums) {
        // try both combination
        return helper(nums,true) || helper(nums,false);
    }
    boolean helper(int[] nums,boolean singleDigitForAlice){
        int alice = 0;
        int bob = 0;
        for(int num : nums){
            if(singleDigitForAlice){
                if(num <= 9){
                    alice += num;
                }else{
                    bob += num;
                }
            }else{
                if(num <= 9){
                    bob += num;
                }else{
                    alice += num;
                }
            }
        }
        if(singleDigitForAlice) return alice > bob;
        return bob < alice;
    }
}