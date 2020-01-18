class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
                System.out.println(Arrays.toString(nums));
            }
        }
        for(int j=index;j<nums.length;j++){
            nums[j]=0;
        }
        
    }
}
