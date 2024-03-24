
// Tag - Medium
class Solution {
    public Node cloneGraph(Node node) {
        // If the original node is null, return null.
        if (node == null) return node;
        
        // Map to store the mapping between original nodes and their clones.
        Map<Node, Node> map = new HashMap<>();
        
        // Call the helper function to clone the graph recursively.
        return clone(node, map);
    }
    
    // Helper function to clone the graph recursively.
    private Node clone(Node node, Map<Node, Node> map) {
        // Create a clone of the current node.
        Node clonedNode = new Node(node.val);
        
        // Add the mapping between the original node and its clone to the map.
        map.put(node, clonedNode);
        
        // Iterate through the neighbors of the original node.
        for (Node neighbor : node.neighbors) {
            // If the neighbor has not been cloned yet, recursively clone it.
            if (!map.containsKey(neighbor)) {
                clonedNode.neighbors.add(clone(neighbor, map));
            } else {
                // If the neighbor has already been cloned, retrieve its clone from the map.
                clonedNode.neighbors.add(map.get(neighbor));
            }
        }
        
        // Return the cloned node.
        return clonedNode;
    }
}
