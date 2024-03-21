
// Tag - Medium
class Solution {
    public int findMinArrowShots(int[][] points) {
        // Sort the points based on their end positions.
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrows = 1; // Initial number of arrows.
        int reach = points[0][1]; // Initial reach with first balloon.
        // Iterate through the points.
        for (int i = 1; i < points.length; i++) {
            // If the current balloon doesn't intersect with the reach, increment arrow count and update reach.
            if (points[i][0] > reach) {
                arrows++;
                reach = points[i][1];
            }
        }
        return arrows; // Return the minimum arrows needed.
    }
}
