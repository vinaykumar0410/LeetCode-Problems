
// Tag - Medium

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        for(int num : nums){
            int temp = num;
            int digitSum = 0;
            while(temp > 0){
                digitSum += temp%10;
                temp /= 10;
            }
            if(!map.containsKey(digitSum)){
                map.put(digitSum, new PriorityQueue<>());
            }
            map.get(digitSum).offer(num);
            if(map.get(digitSum).size() > 2){
                map.get(digitSum).poll();
            }
        }
        int ans = -1;
        for(int key : map.keySet()){
            if(map.get(key).size() == 2){
                ans = Math.max(ans, map.get(key).poll() + map.get(key).poll());
            }
        }
        return ans;
    }
}

/*

// TLE
class Solution {
    public int maximumSum(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(helper(nums[i], nums[j])){
                    pq.offer(nums[i]+nums[j]);
                }
            }
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
    boolean helper(int num1, int num2){
        int sum = 0;
        while(num1 > 0){
            sum += num1%10;
            num1 /= 10;
        }
        while(num2 > 0){
            sum -= num2%10;
            num2 /= 10;
        }
        return sum == 0;
    }
}

*/