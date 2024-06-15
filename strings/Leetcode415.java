
// Tag - Easy

class Solution {
    public String addStrings(String num1, String num2) {
        // start adding numbers from end
        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum = 0;
        // so that we can store carry for future
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        // loop until both numbers are completed
        while(i >= 0 || j >= 0){
            // within condition take that element else take 0
            int first = i>=0 ? num1.charAt(i)-'0' : 0;
            int second = j>=0 ? num2.charAt(j)-'0' : 0;
            sum = first + second + carry;
            sb.append(sum%10);
            carry = sum/10;
            // decrement both for every iteration
            i--;
            j--;
        }
        // carry should be considered for correct output
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}