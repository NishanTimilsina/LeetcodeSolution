class Solution {
    public int countBattleships(char[][] board) {
        
        int max = 0;
        
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[i].length;j++){
                
                if(board[i][j]=='X'){
                    sink(i,j,board);
                    max++;
                }
            }
        }
        return max;
    }
    
    public void sink(int i, int j , char[][] board){
        
        if(i<0 || i>= board.length || j<0 || j>= board[i].length || board[i][j]!='X'){
            return;
        }
        
        board[i][j] = '.';
        sink(i+1,j,board);
        sink(i-1,j,board);
        sink(i,j+1,board);
        sink(i,j-1,board);
    }
}
