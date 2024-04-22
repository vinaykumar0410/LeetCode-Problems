
// Tag - Easy
class Solution {
    int getGcd(int first, int second) {
        // If the first integer is 0, return the second integer as the GCD
        if (first == 0) return second;
        // Recursively call getGcd with the remainder of second divided by first and first
        return getGcd(second % first, first);
    }

    public String gcdOfStrings(String str1, String str2) {
        // If concatenating str1 and str2 does not equal concatenating str2 and str1, there's no common divisor
        if (!(str1 + str2).equals(str2 + str1)) return "";

        // Get the lengths of the two strings
        int first = str1.length();
        int second = str2.length();

        // Get the greatest common divisor of the lengths
        int gcd = getGcd(first, second);

        // Return the substring of str1 from index 0 to gcd (exclusive)
        return str1.substring(0, gcd);
    }
}
