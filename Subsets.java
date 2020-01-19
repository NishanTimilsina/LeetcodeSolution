//https://leetcode.com/problems/subsets/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      
        List<List<Integer>> subset = new ArrayList();
        generateSubSet(0,nums,new ArrayList<Integer>(),subset);
        return subset;
        
    }
    
    public void generateSubSet(int index,int[] nums,List<Integer> current,List<List<Integer>> subset){
        
        subset.add(new ArrayList<Integer>(current));
        for(int i=index;i<nums.length;i++){
            current.add(nums[i]);
            generateSubSet(i+1,nums,current,subset);
            current.remove(current.size()-1);
        }
         
    }
}
