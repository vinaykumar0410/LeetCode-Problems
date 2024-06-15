
// Tag - Easy

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int moves = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        // 1 3 5
        // 2 4 7
        for(int i=0; i<seats.length; i++){
            moves += Math.abs(students[i]-seats[i]);
        } 
        return moves;
    }
}