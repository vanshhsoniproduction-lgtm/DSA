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
    public static int heightl(TreeNode node){
        int h = 0 ;
        while(node !=null){
            h++;
            node = node.left;
        }
        return h;
    }
    public static int heightr(TreeNode node){
        int h = 0 ;
        while(node !=null){
            h++;
            node = node.right;
        }
        return h;
    }
    public static int cc(TreeNode node){
        if(node == null){return 0;}
        if(heightr(node)==heightl(node)){
            return (int)Math.pow(2, heightr(node)) - 1;
        }else{
            return 1 + cc(node.left) + cc(node.right);
        }
    }
    public int countNodes(TreeNode root) {
        int x = heightl(root);
        int xx = heightr(root);
        if(heightl(root)==heightr(root)){
            return (int)Math.pow(2, x) - 1;
        }else{
            return 1 + cc(root.left) + cc(root.right);
        }
    }
}