
// Tag - Easy
class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for(int num : nums){
            int[] arr = getMaxAndCount(num);
            // destructure max value and cnt
            int max = arr[0];
            int cnt = arr[1];
            int currSum = 0;
            // loop cnt times and generate max digit num cnt times
            for(int i=0; i<cnt; i++){
                currSum = currSum*10 + max;
            }
            sum += currSum;
        }
        return sum;
    }
    // method to find max digit in a number and cnt of digits
    private int[] getMaxAndCount(int num){
        int ans = num%10;
        int cnt = 0;
        while(num > 0){
            int r = num%10;
            if(r > ans) ans = r;
            num /= 10;
            cnt++;
        }
        return new int[]{ans,cnt};
    }
}

