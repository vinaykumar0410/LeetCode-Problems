
// Tag - Medium
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Create a map to store the frequency of each element in the array.
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        // Create a priority queue to store the frequencies.
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.values());

        // Remove elements from the priority queue until k becomes 0.
        while (k > 0) {
            k -= pq.poll();
        }

        // Return the size of the priority queue.
        // If k is less than 0, it means we removed more elements than `k`, so we add 1 to the size of the priority queue.
        return k < 0 ? pq.size() + 1 : pq.size();
    }
}
