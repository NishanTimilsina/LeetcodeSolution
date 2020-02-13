class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        HashMap<String, Integer> hash = new HashMap<String,Integer>();
        
        for(int i=0;i<s.length();i++){
            
            for(int j=i;j<=s.length();j++){
                
                String value = s.substring(i,j);
                
                if(!hash.containsKey(value)){
                    hash.put(value,1);
                }else{
                    
                    hash.put(value,hash.get(value)+1);
                }
            }
        }
        
        hash.forEach((k,v)->System.out.println(k+","+v));
        
        for(int i=0;i<wordDict.size();i++){
            
            String val = wordDict.get(i);
            if(!hash.containsKey(val)){
                return false;
            }
        }
        return true;
    }
}
