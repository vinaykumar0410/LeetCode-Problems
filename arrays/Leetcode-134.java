
// Tag - Medium
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Calculate total gas and total cost.
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0; i<gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // If total gas is less than total cost, cannot complete the circuit.
        if(totalGas < totalCost) return -1;

        // Try starting from each station to find the starting point that completes the circuit.
        int remGas = 0;
        int start = 0;
        for(int i=0; i<gas.length; i++){
            // Calculate remaining gas after reaching current station.
            remGas += gas[i] - cost[i];
            // If remaining gas becomes negative, update start to the next station and reset remaining gas.
            if(remGas < 0){
                start = i+1;
                remGas = 0;
            }
        }

        // Return the starting station that completes the circuit.
        return start;
    }
}

