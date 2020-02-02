class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<String>();
        
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board.length;j++){
                
                char value = board[i][j];
                
                if(value !='.'){
                    
                    if(!set.add(value +" found in row "+i)||
                      !set.add(value +" found in column "+j)||
                       !set.add(value +" found in sub "+i/3+"-"+j/3)
                      )
                    
                    return false;
                }
            }
        }
        return true;
    }
}
