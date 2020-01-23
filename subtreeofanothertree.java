//https://leetcode.com/problems/subtree-of-another-tree/

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(s==null){
            return true;
        }
        if(t==null){
            return false;
        }
        
        //check trees are identical or not
        if(IsIdentical(s,t))
        {
            return true;
        }
        
        return isSubtree(s.left,t)|| isSubtree(s.right,t);
        
    }
    
    public boolean IsIdentical(TreeNode s,TreeNode t){
        
        if(s==null && t==null){
            return true;
        }
        
        if(s==null || t==null){
            return false;
        }
        
        return (s.val==t.val && IsIdentical(s.left,t.left)&&IsIdentical(s.right,t.right));
    }
}
