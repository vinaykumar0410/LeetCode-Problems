
// Tag - Easy

class Solution {
    public String convertDateToBinary(String date) {
        StringBuilder ans = new StringBuilder();
        // extract year month & day from input string
        int year =  Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        // append binary version of year followed by -
        ans.append(helper(year));
        ans.append("-");
        // append binary version of month followed by -
        ans.append(helper(month));
        ans.append("-");
        // finally append binary version of day
        ans.append(helper(day));
        return ans.toString();
    }
    // helper method to convert decimal to binary format
    String helper(int num){
        StringBuilder curr = new StringBuilder();
        while(num > 0){
            curr.append(num%2);
            num /= 2;
        }
        return curr.reverse().toString();
    }
}