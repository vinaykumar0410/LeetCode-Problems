
// Tag - Medium

class Solution {
    public int minSetSize(int[] arr) {
        // map holds freq of each num
        Map<Integer,Integer> map = new HashMap();
        for(int num : arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // freq array holds freq of each num
        int[] freq = new int[map.size()];
        int index = 0;
        // populate freq array
        for(int value : map.values()){
            freq[index++] = value;
        }
        // sort freq array
        Arrays.sort(freq);
        int i = freq.length-1;
        int ans = 0;
        int cnt = 0;
        // count till half of array is reached
        while(cnt < arr.length/2){
            // add freq to ans & increment ans
            ans++;
            cnt += freq[i--];
        }
        return ans;
    }
}