//https://leetcode.com/problems/single-number/

class Solution {
    public int singleNumber(int[] nums) {
        
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            
            if(hash.containsKey(nums[i])){
                
                hash.put(nums[i],hash.get(nums[i])+1);
                
            }else{
                
                hash.put(nums[i],1);
            }
        }
        
        for(int key: hash.keySet()){
            if(hash.get(key)==1){
                return key;
            }
        }
        
        return -1;
    }
}
