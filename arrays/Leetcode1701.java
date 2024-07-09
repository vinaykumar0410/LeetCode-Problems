
// Tag - Medium

class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitTime = 0;
        double idleTime = 1; // can take 0 as well
        for(int[] customer : customers){
            double arrivalTime = customer[0];
            double orderTime = customer[1];
            // chef is free
            if(idleTime <= arrivalTime){
                idleTime = arrivalTime + orderTime; // 1+2
            }else{ // chef is busy
                idleTime += orderTime;  // 3+5 8+3
            }
            // cal waiting time
            totalWaitTime += idleTime - arrivalTime; // 3-1 8-2 11-4
        }
        // cal avg
        return totalWaitTime/customers.length; // 2+6+7/3 = 5
    }
}