//https://leetcode.com/problems/invert-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
     
        if(root==null){
            return root;
        }else{
            
            TreeNode temp=root.right;
            root.right=invertTree(root.left);
            root.left=invertTree(temp);
            return root;
        }
        
    }
}
