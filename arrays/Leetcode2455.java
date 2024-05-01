
// Tag - Easy
class Solution {
    public int averageValue(int[] nums) {
        // formula -> avg = sum/cnt
        int sum = 0;
        int cnt = 0;
        for(int num : nums){
            // condition for even and divisble by 3
            if(num%2==0 && num%3==0){
                sum += num;
                cnt++;
            } 
        }
        if(sum==0) return 0;
        return sum/cnt;
    }
}