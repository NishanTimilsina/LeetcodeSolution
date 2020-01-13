//https://leetcode.com/problems/find-all-duplicates-in-an-array/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        List<Integer> list =new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            
            if(hash.containsKey(nums[i])){
                
                hash.put(nums[i],hash.get(nums[i])+1);
                list.add(nums[i]);
            }else{
                hash.put(nums[i],1);
            }
        }
        return list;
        
    }
}
