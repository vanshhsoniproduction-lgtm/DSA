/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int h(TreeNode node, int height){
        if(node==null){return 0;}
        height++;
        return 1+Math.max(h(node.left, height), h(node.right, height));

    }
    public int maxDepth(TreeNode root) {
        int x = 0;
        int height = h(root, x);
        return height;

        
    }
}