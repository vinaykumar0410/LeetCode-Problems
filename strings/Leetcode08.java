
// Tag - Medium
class Solution {
    public int myAtoi(String s) {

        s = s.trim(); // to eliminate leading spaces

        if(s.length() == 0) return 0; // normal edgecase
        
        int sign = 1; // edgecase no.2
        if(s.charAt(0) == '-') sign = -1;

        // i pointer decides where to start the loop
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

        long ans = 0; // stores result
        
        int max = Integer.MAX_VALUE; // int max limit
        int min = Integer.MIN_VALUE; // int min limit

        // traverse string && non digit character found ? exit loop
        while(i < s.length()){

            char ch = s.charAt(i);

            // may be ' ' exists after '+'/'-' 
            if(ch == ' ' || !Character.isDigit(ch)) break; 
            
            // found valid converable string
            ans = ans*10 + ch-'0';

            // edgecase no.5
            if(sign == -1 && -1*ans < min) return min;
            if(sign == 1 && ans > max) return max;

            // missed incrementing ? do it now
            i++;
        }
        // return in int with sign 
        return (int) (ans*sign);
    }
}
