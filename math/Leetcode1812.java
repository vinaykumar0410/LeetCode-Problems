
// Tag - Easy
class Solution {
    public boolean squareIsWhite(String coordinates) {
        int col = coordinates.charAt(0)-'a'; // 0  
        int row = coordinates.charAt(1)-'0'; // 1  
        return !(col%2==0 && row%2==1 || col%2==1 && row%2==0);
    }
}