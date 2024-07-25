
// Tag - Medium

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        // Map to store TreeNode objects with their values as keys
        Map<Integer, TreeNode> map = new HashMap<>();
        // Set to keep track of child nodes
        Set<Integer> children = new HashSet<>();
        // Iterate over the descriptions array to build the tree
        for(int[] description : descriptions) {
            int parent = description[0]; // Parent node value
            int child = description[1];  // Child node value
            int isLeft = description[2]; // Flag to indicate if child is left (1) or right (0)
            // Add child to the set of children
            children.add(child);
            // Create parent node if it doesn't exist in the map
            map.putIfAbsent(parent, new TreeNode(parent));
            // Create child node if it doesn't exist in the map
            map.putIfAbsent(child, new TreeNode(child));
            // Assign child node to the left or right of the parent node based on isLeft flag
            if(isLeft == 1) {
                map.get(parent).left = map.get(child);
            }else {
                map.get(parent).right = map.get(child);
            }
        }
        // Iterate again to find the root node (the one not in children set)
        for (int[] description : descriptions) {
            if (!children.contains(description[0])) {
                return map.get(description[0]); // Return the root node
            }
        }
        // Return null if no root is found (shouldn't happen in a valid tree)
        return null;
    }
}