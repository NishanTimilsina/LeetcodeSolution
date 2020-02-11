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
    public int maxDepth(TreeNode root) {
        if(root==null){return 0;}
        Queue<TreeNode> q1 = new LinkedList();
        q1.add(root);
        int level=0;
        while(!q1.isEmpty()){
            
            int size = q1.size();
            level++;
            for(int i=0;i<size;i++){
                
                TreeNode current = q1.remove();
                if(current.left!=null){q1.add(current.left);}
                if(current.right!=null){q1.add(current.right);}
            }
        }
        return level;
    }
}
