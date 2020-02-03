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
    public boolean isValidBST(TreeNode root) {
     
        
        return ValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public boolean ValidBST(TreeNode root,int min,int max){
        
        if(root==null){
            return true;
        }
        if( ( root.val<= min) || (root.val>= max)){
            return false;
        }
        
        return          (ValidBST(root.left,min,root.val)&&ValidBST(root.right,root.val,max));
    }
}
