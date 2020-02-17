class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        char[] x = text1.toCharArray();
        char[]  y=text2.toCharArray();
        int m = x.length;
        int n = y.length;
        return CommonSubsequence(x,y,m,n);
    }
    
    public int CommonSubsequence(char[] x,char[] y, int m,int n){
        
        if(m==0 || n == 0){
            return 0;
        }
        if(x[m-1]==y[n-1]){
            return 1 + CommonSubsequence(x,y,m-1,n-1);
        }
        else{
            return Math.max(CommonSubsequence(x,y,m,n-1),CommonSubsequence(x,y,m-1,n));
        }
    }
}
