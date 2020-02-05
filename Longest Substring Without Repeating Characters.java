class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0 || s==null){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        
        List<String> list = new ArrayList();
        HashMap<String,Integer> hash = new HashMap();
        String longestStr = "";
        
        for(int i=0;i<s.length();i++){
            
            for(int j=i;j<s.length();j++){
                
                String str = s.substring(i,j+1);
                
                char[] strC  = str.toCharArray();
                
                Arrays.sort(strC);
                
                str = new String(strC);
                
                if(!isRepet(str)){
                    
                if(hash.containsKey(str)){
                    
                    if(str.length()>longestStr.length()){
                        
                        longestStr = str;
                    }
                    
                   hash.put(str,hash.get(str)+1); 
                }else{
                    hash.put(str,1);
                }
                list.add(str);
                }
            }
        }
        hash.forEach((k,v)->System.out.println(k+","+v));
        
        return longestStr.length();
    }
    
    public boolean isRepet(String s){
        
        for(int i=0;i<s.length();i++){
            
            for(int j=i+1;j<s.length();j++){
                
                if(s.charAt(i)==s.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
}
