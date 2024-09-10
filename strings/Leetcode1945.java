
// Tag - Easy

class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        // convertion & 1st transform
        for(char ch : s.toCharArray()){
            int num = ch-'a'+1;
            while(num > 0){
                sum += num%10;
                num /= 10;
            }
        }
        // more than 1 tranform
        while(k-->1){
            int newSum = 0;
            while(sum > 0){
                newSum += sum%10;
                sum /= 10;
            }
            sum = newSum;
        }
        return sum;
    }
}