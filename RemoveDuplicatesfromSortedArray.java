//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int max=1;
        
        for(int i=0;i<nums.length-1;i++){
            
            if(nums[i]!=nums[i+1]){
                System.out.println("nums[i] "+nums[i]+" and nums[i+1] "+nums[i+1]);
                nums[max++]=nums[i+1];
            }
        }
        return max;
    }
}
