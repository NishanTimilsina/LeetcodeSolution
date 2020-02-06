class Solution {
    public int[][] generateMatrix(int n) {
        
        int columnStart = 0;
        int columnEnd = n-1;
        int rowStart = 0;
        int rowEnd = n-1 ;
        int count = 1;
        int[][] matrix = new int[n][n];
        
        while(columnStart<=columnEnd && rowStart<=rowEnd){
            
            for(int i= columnStart;i<=columnEnd;i++ ){
                matrix[rowStart][i]=count;
                count++;
            }
            rowStart++;
            
            for(int j= rowStart;j<=rowEnd;j++){
                matrix[j][columnEnd] = count;
                count++;
            }
            columnEnd--;
            
            if(rowStart<=rowEnd){
                
                for(int i=columnEnd;i>=columnStart;i--){
                    matrix[rowEnd][i]=count;
                    count++;
                }
            }
               rowEnd--;
               
               if(columnStart<=columnEnd){
               for(int k=rowEnd;k>=rowStart;k--){
                   matrix[k][columnStart]=count;
                   count++;
               }
               }
               
               columnStart++;
        }
               return matrix;
    }
}
