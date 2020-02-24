/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return createBST(nums,0,nums.length-1);
        
    }
    
    public TreeNode createBST(int[] nums,int low, int high){
        
        if(low>high){
            return null;
        }
        
        int mid = low+(high-low)/2;
        
        TreeNode tree = new TreeNode(nums[mid]);
        
        tree.left = createBST(nums,low,mid-1);
        tree.right = createBST(nums,mid+1,high);
        return tree;
    }
}
