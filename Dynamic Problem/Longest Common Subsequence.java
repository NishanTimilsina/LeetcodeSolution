//https://leetcode.com/problems/longest-common-subsequence/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
     
        int m = text1.length();
        int n = text2.length();
        
        int[][] match = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            
            for(int j=1;j<=n;j++){
                
                //if current char is match
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    
                    //add 1 on its diagonal value
                    match[i][j] = 1+ match[i-1][j-1];
                }else{
                    
                    match[i][j] = Math.max(match[i][j-1],match[i-1][j]);
                }
            }
        }
        return match[m][n];
    }
}
