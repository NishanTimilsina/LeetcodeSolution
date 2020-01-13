//https://leetcode.com/problems/longest-common-prefix/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String longestCommonPrefix="";
        int index=0;
        
        for(char ch:strs[0].toCharArray()){
            
            for(int i=0;i<strs.length;i++){
                
                if(index>=strs[i].length()||strs[i].charAt(index)!=ch){
                    return longestCommonPrefix;
                }
            }
                            
                longestCommonPrefix+=ch;
                index++;
        }
        
        return longestCommonPrefix;
    }
}
