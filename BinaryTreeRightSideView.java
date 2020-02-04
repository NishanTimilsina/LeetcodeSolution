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
    	public static int currentLevel =0;
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList();
        rightView(root,1,result);
        return result;
    }
    public void rightView(TreeNode root, int nextLevel,List<Integer> result){
        
        if(root==null){
            return;
        }
        
        if(currentLevel<nextLevel){
            result.add(root.val);
            currentLevel = nextLevel;
        }
        rightView(root.right,nextLevel+1,result);
        rightView(root.left,nextLevel+1,result);

        
    }
}
