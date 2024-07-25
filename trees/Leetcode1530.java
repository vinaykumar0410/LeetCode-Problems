
// Tag - Medium

class Solution {
    int pairs = 0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return pairs;
    }
    List<Integer> dfs(TreeNode root,int distance){
        // base condition
        if(root == null){
            return new ArrayList();
        }
        // found leaf node
        if(root.left == null && root.right == null){
            List<Integer> list = new ArrayList();
            list.add(1);
            return list;
        }
        // get distances from both subtrees
        List<Integer> left_dists = dfs(root.left,distance);
        List<Integer> right_dists = dfs(root.right,distance);
        // check if distance btn pairs is less than or equals given distance
        for(int left_dist : left_dists){
            for(int right_dist : right_dists){
                if(left_dist + right_dist <= distance){
                    // pair found
                    pairs++;
                }
            }
        }
        // update distance for parent nodes
        List<Integer> total_dists = new ArrayList();
        for(int dist : left_dists) total_dists.add(dist+1);
        for(int dist : right_dists) total_dists.add(dist+1);

        return total_dists;
    }
}