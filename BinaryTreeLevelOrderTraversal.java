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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> tree = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Integer> temp = new ArrayList();
            
            for(int i=0;i<size;i++){
                
            TreeNode current = queue.poll();
            temp.add(current.val);
            
            if(current.left!=null){
                queue.offer(current.left);
            }
            if(current.right!=null){
                queue.offer(current.right);
            } 
            }
           tree.add(temp); 
        }
        return tree;
    }
}
