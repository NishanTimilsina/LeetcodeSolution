class Solution {
    public int[] sortedSquares(int[] A) {
        
        int[] result = new int[A.length];
        for(int i=0;i<A.length;i++){
            
            result[i]=square(A[i]);
        }
        
        for(int i=0;i<result.length;i++){
            
            for(int j=0;j<result.length;j++){
                
                sort(result,i,j);
            }
        }
        return result;
    }
    
    public void sort(int[] nums,int i,int j){
        
        if(nums[i]<nums[j]){
            
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
    
    public int square(int a){
        
        return (a*a);
    }
}
