class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if(grid == null || grid.length<0 ){
            return 0;
        }
        
        for(int i=0;i<grid.length;i++){
            
            for(int j=0;j<grid[i].length;j++){
                
            if(grid[i][j]==1){
                    
                perimeter += 4;
                        
                if(i>0 && grid[i-1][j]==1){
                    perimeter -= 2;
                }
                
                if(j>0 && grid[i][j-1]==1){
                    perimeter -= 2;
                }
             }
                
            }
        }
        return perimeter;
    }
}
