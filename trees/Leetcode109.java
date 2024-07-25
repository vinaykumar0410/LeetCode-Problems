
// Tag - Medium

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Convert the linked list to an ArrayList to easily access elements by index
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        // Traverse the linked list and add each value to the list
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        // Use the helper method to build the BST from the sorted list
        return helper(list, 0, list.size() - 1);
    }

    // Helper method to recursively construct the BST
    TreeNode helper(List<Integer> list, int l, int h) {
        // Base case: if the low index exceeds the high index, return null
        if (l > h) return null;
        // Find the middle element to make it the root of the current subtree
        int mid = (l + h) / 2;
        // Create the root node with the middle element
        TreeNode root = new TreeNode(list.get(mid));
        // Recursively build the left subtree
        root.left = helper(list, l, mid - 1);
        // Recursively build the right subtree
        root.right = helper(list, mid + 1, h);
        // Return the root of the subtree
        return root;
    }
}