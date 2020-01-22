//https://leetcode.com/problems/permutations-ii/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList();
        List<List<Integer>> filterResult = new ArrayList();
        
        doPermutation(nums,0,result);
        HashSet<List<Integer>> hash = new HashSet();
        for(List<Integer> list: result){
                hash.add(list);
        }      
        Iterator<List<Integer>> i=hash.iterator(); 
        while(i.hasNext()){
            filterResult.add(i.next());
        }
        return filterResult;    
    }
    
    public List<List<Integer>> doPermutation(int[] nums,int currentIndex,List<List<Integer>> res){
                
        if(currentIndex == nums.length-1){
            
            List<Integer> temp = new ArrayList();
            for(int a:nums){
                temp.add(a);
            }
            res.add(temp);
        }
        
        for(int i=currentIndex;i<nums.length;i++){
            swap(nums,i,currentIndex);
            doPermutation(nums,currentIndex+1,res);
            swap(nums,i,currentIndex);
        }
        
        return res;
    }
    public void swap(int[] nums,int i,int j){
        
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
