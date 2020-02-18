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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        
        Queue<TreeNode> q1= new LinkedList();
        
        if(root == null){
            return result;
        }
        q1.add(root);
        while(!q1.isEmpty()){
            
            int size = q1.size();
            
            for(int i=0;i<size;i++){
                
                TreeNode current = q1.poll();
                if(i==0){
                    result.add(current.val);
                }
                if(current.right!=null){q1.add(current.right);}
                if(current.left!=null){q1.add(current.left);}

            }
        }
        return result;
    }
}
