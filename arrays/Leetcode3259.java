
// Tag - Medium

class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        
        // Initialize previous values for energyDrinkA and energyDrinkB
        long prevA = energyDrinkA[0];
        long prevB = energyDrinkB[0];
        
        // Iterate through the energy drinks
        for (int i = 1; i < n; i++) {
            // Calculate the current max energy for both drinks
            long currA = Math.max(prevA + energyDrinkA[i], prevB);
            long currB = Math.max(prevB + energyDrinkB[i], prevA);
            
            // Update previous values for the next iteration
            prevA = currA;
            prevB = currB;
        }
        
        // Return the maximum energy boost possible
        return Math.max(prevA, prevB);
    }
}
