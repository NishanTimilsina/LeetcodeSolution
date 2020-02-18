class Solution {
    public int minDistance(String word1, String word2) {
        
        //dynamic solution
        int[][] result = new int[word1.length()+1][word2.length()+1];
        
        for(int i=0;i<=word1.length();i++){
            
            for(int j=0;j<=word2.length();j++){
                
                //if s1 is empty , insert all char from s2
                if(i==0)
                    result[i][j]=j;
                //if s2 is empty insert all char from s1
                else if(j==0)
                    result[i][j]=i;
                
                // last char is matching , no operation required
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    result[i][j]=result[i-1][j-1];
                }
                //not match take min distance from previous operation
                else{
                    result[i][j]= 1+Math.min(Math.min(result[i][j-1],result[i-1][j]),result[i-1][j-1]);
                }
            }
        }
        return result[word1.length()][word2.length()];
    }
}
