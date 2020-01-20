//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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
    public int kthSmallest(TreeNode root, int k) {
        
        int[] nums = new int[2];
        inorder(root,nums,k);
        return nums[1];
    }
    
    public void inorder(TreeNode root,int[] nums,int k){
        
        
        if(root==null){
            return;
        }
        inorder(root.left,nums,k);
        
        if(++nums[0]==k){
            nums[1]=root.val;
        }
       inorder(root.right,nums,k);

    }
}
