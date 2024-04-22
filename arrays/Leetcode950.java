
// Tag - Medium

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // Initialize an array to store the revealed deck
        int[] res = new int[deck.length];
        
        // Create a queue to keep track of indices
        Queue<Integer> q = new LinkedList();
        
        // Sort the deck in increasing order
        Arrays.sort(deck);
        
        // Populate the queue with indices from 0 to deck.length - 1
        for(int i=0; i<deck.length; i++) 
            q.offer(i);
        
        // Iterate over the sorted deck to reveal cards
        for(int i=0; i<deck.length; i++){
            // Get the index from the front of the queue and set the corresponding card in the result
            res[q.poll()] = deck[i];
            // Move the next index to the rear of the queue
            q.offer(q.poll());
        }
        
        // Return the revealed deck
        return res;
    }
}
