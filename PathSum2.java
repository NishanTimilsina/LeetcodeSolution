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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       
        
        List<List<Integer>> paths=new ArrayList<>();
        findpath(paths,sum,new ArrayList<>(),root);
        return paths;
        
        
    }
    
    public void findpath(List<List<Integer>> path,int sum,List<Integer> current,TreeNode root){
        
        if(root==null){
            return ;
        }
        
        current.add(root.val);
        if(root.val==sum &&root.left==null && root.right==null){
            
            path.add(current);
            return;
        }
        
        findpath(path,sum-root.val,new ArrayList<Integer>(current),root.left);
        findpath(path,sum-root.val,new ArrayList<Integer>(current),root.right);

        
        
    }
}
