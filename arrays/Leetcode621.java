
// Tag - Medium
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        
        // Count the frequency of each task.
        for (char task : tasks)
            freq[task - 'A']++;
        
        // Sort the frequencies to find the task with maximum frequency.
        Arrays.sort(freq);
        
        int maxFreq = freq[25]; // Maximum frequency.
        int idle = (maxFreq - 1) * n; // Calculate idle time.
        
        // Iterate through the frequencies to calculate additional idle time.
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxFreq - 1, freq[i]);
        }
        
        // Ensure idle time is non-negative.
        idle = Math.max(0, idle);
        
        // Total time needed = number of tasks + idle time.
        return tasks.length + idle;
    }
}

