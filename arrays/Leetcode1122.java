
// Tag - Easy
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // take out frequency of each number
        int[] map = new int[1001];
        for(int num : arr1) map[num]++;
        // init new array (can modify original input array instead)
        int[] ans = new int[arr1.length];
        int k = 0;
        // fill output array with freq times number with respect to arr2
        for(int num : arr2){
            while(map[num]-->0) ans[k++] = num;
        }
        // add remaining elements to PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<arr1.length; i++){
            if(map[arr1[i]]>0) pq.offer(arr1[i]);
        }
        // fill output array with remaining elements
        while(!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        return ans;
    }
}