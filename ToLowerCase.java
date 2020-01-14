//https://leetcode.com/problems/to-lower-case/submissions/
class Solution {
    public String toLowerCase(String str) {
        
        String resultString="";
        for(int i=0;i<str.length();i++){
            
            int ascii=(int)str.charAt(i);
            
            if(ascii>=65 && ascii<=90){
                
                int small= ascii+32;
                resultString += (char)small;
            }
            else {
                resultString += str.charAt(i);
            }
        }
        
        return resultString;
    }
}
