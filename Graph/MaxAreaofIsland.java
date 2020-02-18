//https://leetcode.com/problems/max-area-of-island/


class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        
        int max=0;
        for(int i=0;i<grid.length;i++){
            
            for(int j=0;j<grid[i].length;j++){
                
                max=Math.max(max,dfs(i,j,grid));
            }
        }
             return max;                
    }
                             
      public int dfs(int i,int j,int[][] grid){
          
          if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]==0){
              return 0;
          }
      
        grid[i][j]=0;
        int count=1;
        count+=dfs(i+1,j,grid);
        count+=dfs(i-1,j,grid);
        count+=dfs(i,j+1,grid);
        count+=dfs(i,j-1,grid);
        return count;
      }
}
