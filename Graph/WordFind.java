

public class Main
{
	public static void main(String[] args) {
	   
	   
	   char[][] matrix={
	       {'A','B','C','E'},
	       {'S','F','C','S'},
	       {'A','D','E','E'}
	   }; 
	   int m=4;
	   int n=3;
	   String word= "ABCB";
	   
	   boolean result = DFSSearch(matrix,m,n,word);
	   
	   System.out.println(result);
	    
}

public static boolean DFSSearch(char[][] matrix,int m,int n,String word){
    
    for(int i=0;i<m;i++){
	       for(int j=0;j<n;j++){
	           
	         if(word.charAt(0)==matrix[i][j] && DFS(matrix,i,j,0,word)){
	             return true;
	         }

	       }
	   }
	   
	   return false;
}

    public static boolean DFS(char[][] matrix,int i,int j,int count,String word){
    
    
    try{
        if(word.length()-1==count){
        return true;
    }
    
    if(i<0||i>=word.length()||j<0||j>=matrix[0].length || matrix[i][j]!=word.charAt(count)){
        return false;
    }
        
        
    
    char temp=matrix[i][j];
    matrix[i][j]=' ';
    boolean found= DFS(matrix,i+1,j,count+1,word)|| DFS(matrix,i-1,j,count+1,word)
            || DFS(matrix,i,j+1,count+1,word)||DFS(matrix,i,j-1,count+1,word);
    matrix[i][j]=temp;
    return found;
    }catch(Exception e){
        	   System.out.println(e);

    }
    return false;
   
    }
    
    
}
