class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int count=0;
        int result = 0;
        
        for(int value:nums){
            
            if(value==0){
                count=0; //reset count
            }else{
                count++;
                result = Math.max(result,count);
            }
        }
    }
}
