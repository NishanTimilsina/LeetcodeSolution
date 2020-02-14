class Solution {
    public boolean exist(char[][] board, String word) {
     
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                    
                if(board[i][j]==word.charAt(0) && dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i,int j,int index,char[][] board,String word){
        
        if(word.length()==index){
            return true;
        }
        
        if(i<0 || j<0 || i>=board.length || j>=board[i].length ||  word.charAt(index)!=board[i][j]){
            return false;
        }
        
        
        char temp = board[i][j];
        board[i][j]=' ';
        
        boolean found = dfs(i+1,j,index+1,board,word)||
                        dfs(i-1,j,index+1,board,word)||
                        dfs(i,j+1,index+1,board,word)||
                        dfs(i,j-1,index+1,board,word);
        board[i][j]=temp;
        return found;
    }
}
