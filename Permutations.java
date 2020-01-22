//https://leetcode.com/problems/permutations/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList();
        numberPermutation(nums,0,res);
        return res;
    }
    
    public List<List<Integer>> numberPermutation(int[] nums,int currentIndex,List<List<Integer>> finalRes){
        
        if(nums.length-1==currentIndex){
           List<Integer> temp = new ArrayList();
            for(int a:nums){
               temp.add(a);
            }
            finalRes.add(temp);
            System.out.println(Arrays.toString(nums));
        }
        
        for(int i=currentIndex;i<nums.length;i++){
            
            swap(nums,i,currentIndex);
            numberPermutation(nums,currentIndex+1,finalRes);
            swap(nums,i,currentIndex);
        }
        return finalRes;
    }
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
