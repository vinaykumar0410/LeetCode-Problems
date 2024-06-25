
// Tag - Easy
class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double min = 51;
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            double sum = nums[i]+nums[j];
            min = Math.min(min,sum/2);
            i++;
            j--;
        }
        return min;
    }
}