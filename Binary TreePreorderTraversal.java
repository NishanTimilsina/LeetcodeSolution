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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        
        preOrderBST(root,result);
        
        return result;
        
    }
    
    public void preOrderBST(TreeNode root,List<Integer> result){
        
        if(root==null){
            return;
        }
        result.add(root.val);
        preOrderBST(root.left,result);
        preOrderBST(root.right,result);
        

    }
}
