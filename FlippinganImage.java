class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        for(int i=0;i<A.length;i++){
            
            for(int j=0;j<A[i].length/2;j++){
                
                swap(i,j,A);
            }
        }
        return invertImage(A);
    }
    
    public void swap(int i ,int j, int[][] A){
        
        int temp = A[i][j];
        A[i][j] = A[i][A.length-1-j];
        A[i][A.length-1-j] = temp;
    }
    public int[][] invertImage(int[][] A){
        for(int i=0;i<A.length;i++){
            
            for(int j=0;j<A[i].length;j++){
                
                if(A[i][j]==1){
                    A[i][j]=0;
                }else{
                   A[i][j]=1; 
                }
            }
        }
        return A;
    }
}
