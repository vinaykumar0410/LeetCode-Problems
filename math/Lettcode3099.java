
// Tag - Easy

class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        // Initialize sum variable
        int sum = 0; 
        // Store the number in a separate variable
        int num = x; 
        // Loop to sum the digits of the number
        while (num > 0) {
            sum += num % 10; // Add the last digit to the sum
            num /= 10; // Remove the last digit from the number
        }
        // Check if the original number is divisible by the sum of its digits
        return x % sum == 0 ? sum : -1; 
    }
}
