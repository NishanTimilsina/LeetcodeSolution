class Solution {
    public int[] searchRange(int[] nums, int target) {
       int[] result = new int[2];
       result[0]=  findFirstIndex(nums,target);
        result[1]=  findSecondIndex(nums,target);
        return result;
    }
    
    public int findFirstIndex(int[] nums, int target){
        
        int index= -1;
        int first=0;
        int last = nums.length-1;
        
        while(first<=last){
            
            int mid = first + (last-first)/2;
            
            if(nums[mid] >= target){
                last = mid-1;
            }else{
                first = mid+1;
            }
            
            if(nums[mid]==target){
                index = mid;
            }
        }
        return index;
    }
    public int findSecondIndex(int[] nums, int target){
        
        int index= -1;
        int first=0;
        int last = nums.length-1;
        
        while(first<=last){
            
            int mid = first + (last-first)/2;
            
            if(nums[mid]<=target){
                first = mid+1;
            }else{
               last = mid-1;
            }
            
            if(nums[mid]==target){
                index = mid;
            }
        }
        return index;
    }
}
