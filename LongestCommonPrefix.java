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
/********************** next solution ****************/
//fast solution

class Solution {
    public String longestCommonPrefix(String[] strs) {
           
        String commonpre= "";

        if(strs==null || strs.length<=0){
            return commonpre;
        }
        int first = 0;
        int min = getMinString(strs);
        int last = min;


        while(first<=last){
            
            int mid = first+(last-first)/2;
            
            if(isLongestprefix(strs,strs.length,strs[0],first,mid)){
            
                
                //add prefix
                commonpre += strs[0].substring(first,mid+1);
                
                first = mid+1;
                
            }else{
                last = mid-1;
            }
            
        }
        
        return commonpre;
    }
    
    public boolean isLongestprefix(String[] strs,int n,String str,int start,int end){
        
        for(int i=0;i<strs.length;i++){
            
            String value = strs[i];
            
            for(int j=start;j<=end;j++){
                
                if(value.charAt(j)!=str.charAt(j))
                    return false;
            }
        }
        return true;
    }
    
    public int getMinString(String[] str){
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<str.length;i++){
            
            if(str[i].length()<min){
                min = str[i].length();
            }
        }
        return min;
    }
}
