
// Tag - Easy
class Solution {
    public String losingPlayer(int x, int y) {
        // Counter to keep track of the number of rounds played
        int cnt = 0;

        // Loop until one player runs out of their required resources
        while (x > 0 && y >= 4) {
            cnt++; // Increment round counter
            x--;   // Decrease x (one unit consumed)
            y -= 4; // Decrease y (four units consumed)
        }

        // If the number of rounds is even, Bob loses; otherwise, Alice loses
        return cnt % 2 == 0 ? "Bob" : "Alice";
    }
}
