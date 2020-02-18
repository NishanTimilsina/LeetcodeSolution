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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        inOrder(root,result);
        return result;
    }
    
    //in order traversal LEFT->ROOT->RIGHT
    public void inOrder(TreeNode root, List<Integer> result){
        
        if(root==null){
            return;
        }
        
        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }
}
