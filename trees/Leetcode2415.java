
// Tag - Medium

// bfs

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        // bfs + two pointer
        if(root == null){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> curr = new ArrayList();
            while(size-->0){
                TreeNode node = q.poll(); 
                curr.add(node);
                if(node.left != null){
                    q.offer(node.left);
                } 
                if(node.right != null){
                    q.offer(node.right);
                } 
            }
            if(level%2==1){
                int l = 0;
                int r = curr.size()-1;
                while(l < r){
                    int temp = curr.get(l).val;
                    curr.get(l).val = curr.get(r).val;
                    curr.get(r).val = temp;
                    l++;
                    r--;
                }
            }
            level++;
        }
        return root;
    }
}

// dfs

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 0);
        return root;
    }
    void dfs(TreeNode node1, TreeNode node2, int depth){
        if(node1 == null || node2 == null){
            return;
        }
        if(depth%2==0){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        dfs(node1.left, node2.right, depth+1);
        dfs(node1.right, node2.left, depth+1);
    }
}