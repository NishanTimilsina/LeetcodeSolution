//https://leetcode.com/problems/number-of-islands/
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    numIslands(grid,i,j);
                }
            }
        }
    return count;
    }
    
    public void numIslands(char[][] grid,int i,int j){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length|| grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        numIslands(grid,i+1,j);//up
        numIslands(grid,i-1,j);//down
        numIslands(grid,i,j+1);//left
        numIslands(grid,i,j-1);//right
    }
}
