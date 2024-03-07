

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Pointers for the start and end of tokens.
        int i = 0; 
        int j = tokens.length - 1; 
        // Sort the tokens array.
        Arrays.sort(tokens); 

        // Initialize the current score and max to 0.
        int score = 0; 
        int max = 0; 

        while (i <= j) {
            // If the token at 'i' can be played with the current power.
            if (tokens[i] <= power) { 
                // Consume the token, reduce power, and move to the next token.
                power -= tokens[i++]; 
                score++; // Increment the score.
                max = Math.max(max, score); // Update the maximum score if needed.
            } else if (score > 0) { // If positive score and token 'i' cannot be played due to low power.
                // Recharge power by playing a token from the end of the array.
                power += tokens[j--]; 
                score--; // Decrease the score as a token is played from the end.
            } else { // If no more tokens can be played or no tokens are available.
                break; // Exit the loop.
            }
        }
        // Return the maximum score achieved.
        return max; 
    }
}

