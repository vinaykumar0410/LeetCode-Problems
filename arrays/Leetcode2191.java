
// Tag - Medium

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // map num to modified num
        List<int[]> list = new ArrayList();
        for(int num : nums){
            int modifiedNum = getdecodedNum(num,mapping);
            list.add(new int[]{num,modifiedNum});
        }
        // now sort list based on modifiedNum
        Collections.sort(list,(a,b)->{
            // both values are equal ? then no need swap : else swap
            if(a[1] == b[1]){
                return 0;
            }else{
                return a[1]-b[1];
            }
        });
        // assign sorted values to nums array
        for(int i=0; i<nums.length; i++){
            nums[i] = list.get(i)[0];
        }
        return nums;
    }
    private int getdecodedNum(int num,int[] mapping){
        int decodedNum = 0;
        // convert num to string why? (so that we can traverse easily)
        StringBuilder curr = new StringBuilder();
        curr.append(num);
        // traverse on string and decode actually num
        for(int i=0; i<curr.length(); i++){
            int index = curr.charAt(i)-'0';
            decodedNum = decodedNum*10 + mapping[index];
        }
        return decodedNum;
    }
}