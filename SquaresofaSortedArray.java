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


/************ another optinal solution *********/
class Solution {
    public int[] sortedSquares(int[] A) {
        
        // time complexity Big O(N)
        int left = 0;
        int right = A.length-1;
        int[] result = new int[A.length];
        
        for(int  i =A.length-1;i>=0;i--){
            
            if(Math.abs(A[left])>A[right]){
                result[i]=A[left]*A[left];
                left++;
            }else{
                result[i]=A[right]*A[right];
                right--;
            }
        }
        return result;
    }
}
