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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        postOrder(root,result);
        return result;
    }
    
    //POST order traversal is LEFT->RIGHT->ROOT
    public void postOrder(TreeNode root, List<Integer> result){
        
        if(root==null){
            return;
        }
        
        postOrder(root.left,result);
        postOrder(root.right,result);
        result.add(root.val);
    }
}
