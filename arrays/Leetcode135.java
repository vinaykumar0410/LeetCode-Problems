
// Tag - Hard
class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;

        // Arrays to store the number of candies assigned to each child from the left and right side
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize both arrays with 1, as each child should have at least one candy
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // Fill the 'left' array with candies based on the ratings from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Fill the 'right' array with candies based on the ratings from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // Variable to store the total number of candies needed
        int totalCandies = 0;

        // Iterate through each child and calculate the maximum candies needed for fairness
        for (int i = 0; i < n; i++) {
            totalCandies += Math.max(left[i], right[i]);
        }

        // Return the total number of candies needed for fairness
        return totalCandies;
    }
}
