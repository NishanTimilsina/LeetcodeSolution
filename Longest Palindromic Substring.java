class Solution {
    public String longestPalindrome(String s) {
     
        String longestPalindrome = "";
        //brute force  O(n3)
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            
            for(int j=i;j<arr.length;j++){
                
                String str = s.substring(i,j+1);
                
                if(isPalindrome(str) && str.length() > longestPalindrome.length()){
                    longestPalindrome = str;
                }
            }
        }
        return longestPalindrome;
    }
    
    public boolean isPalindrome(String str){
        
        String reverse = "";
        char[] arr = str.toCharArray();
        
        for(int i=arr.length-1;i>=0;i--){
            reverse +=arr[i]; 
        }
        
        if(str.equals(reverse)){
            return true;
        }
        
        return false;
    }
}
