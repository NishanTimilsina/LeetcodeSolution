//https://leetcode.com/problems/reverse-only-letters/
class Solution {
    public String reverseOnlyLetters(String S) {
       
        char[] charArr  = S.toCharArray();
          
        int i=0;
        int j=S.length()-1;
        while(i<j){
            
            while(i<j && !Character.isLetter(S.charAt(i))){
                i++;
            }
            while(j>i && !Character.isLetter(S.charAt(j))){
                j--;
            }
            
            char temp = charArr[i];
            charArr[i++] = charArr[j];
            charArr[j--]=temp;
        }
        return new String(charArr);
    }
}
