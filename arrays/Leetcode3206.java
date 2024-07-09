
// Tag - Easy

class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            // why n-1-i & n+1+i ? 
            // n-1-i gives last index in a circular array when i is on first index
            // we have an array size 5 and we are on 0th index last index of 0th index is 4th index
            // we get 4th index through this formula similarly n+1+i
            if(colors[(n-1-i)%n] != colors[i] && colors[i] != colors[(n+i+1)%n]){
                count++;
            } 
        }
        return count;
    }
}