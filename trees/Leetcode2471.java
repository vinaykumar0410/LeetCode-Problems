
// Tag - Medium

class Solution {
    public int minimumOperations(TreeNode root) {
        int minOperations = 0;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int[] nums = new int[size];
            int i = 0;
            while(size-->0){
                TreeNode node = q.poll();
                nums[i++] = node.val;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            minOperations += minSwaps(nums);
        }
        return minOperations;
    }
    private int minSwaps(int[] nums){
        int swaps = 0;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        // 7 6 8 5
        // 5 6 7 8
        for(int i=0; i<nums.length; i++){
            if(nums[i] != sorted[i]){
                swaps++;
                int pos = map.get(sorted[i]);
                map.put(nums[i], pos);
                nums[pos] = nums[i]; 
            }
        }
        return swaps;
    }
}