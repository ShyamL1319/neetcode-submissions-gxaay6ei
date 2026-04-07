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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            // Case 1: Both p and q are in the right subtree
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            // Case 2: Both p and q are in the left subtree
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            // Case 3: We found the "split point" or one of the nodes is the current node
            else {
                return curr;
            }
        }
        return null;
    }
}