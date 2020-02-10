class Solution {
    public int maxSubArray(int[] nums) {
        
        int max= nums[0];
        int runningMax = nums[0];
        for(int i =1; i<nums.length; i++){
            runningMax = runningMax + nums[i];
            if(runningMax < nums[i]){
                runningMax = nums[i];
                
            }
            if(runningMax > max){
                max = runningMax;
            }
        }
        return Math.max(runningMax, max);
    }
}
