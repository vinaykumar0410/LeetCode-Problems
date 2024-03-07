
// Tag - Medium
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList();
        if (root == null) return list;
        int level = 0;

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> row = new ArrayList();

            for(int i=0; i<size; i++){

                TreeNode curr = q.poll();
                row.add(curr.val);

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            
            if(level%2==0){
                list.add(row);
            }else{
                Collections.reverse(row);
                list.add(row);
            }
            level++;
        }
        return list;
    }
}