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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> result = new ArrayList();
        
        if(root==null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList();
        int sum=0;
        queue.add(root);
        while(!queue.isEmpty()){      
            int size= queue.size();
             sum=0;
            int count=0;
            for(int i=0;i<size;i++){
                TreeNode temp= queue.remove();
                sum+=temp.val;
                count++;
                if(temp.left!=null){
                   queue.add(temp.left); 
                }              
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            double value = (sum*1.00000/count);
            result.add(value);
        }
        return result;
    }
}
