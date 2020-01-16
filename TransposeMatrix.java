class Solution {
    public int[][] transpose(int[][] A) {
        int row=A.length;
        int col=A[0].length;
        int[][] res=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                res[i][j]=A[j][i];
            }
        }
        return res;
    }
}
