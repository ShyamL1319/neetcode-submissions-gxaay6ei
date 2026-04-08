/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 1. Reach the leftmost node of the current subtree
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 2. Process the node (this is the "Root" in L-R-N)
            curr = stack.pop();
            k--; 
            
            if (k == 0) {
                return curr.val;
            }

            // 3. Move to the right subtree
            curr = curr.right;
        }

        return -1; // Should not reach here based on constraints
    }
}