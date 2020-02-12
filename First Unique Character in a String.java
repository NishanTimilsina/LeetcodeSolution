class Solution {
    public int firstUniqChar(String s) {
        
        HashMap<Character,Integer> hash = new HashMap();
        
        for(int i=0;i<s.length();i++){
            
            char key   = s.charAt(i);
            
            if(hash.containsKey(key)){
                hash.put(key, hash.get(key)+1);
            }else{
                hash.put(key,1);
            }
            
        }
        
        for(int i=0;i<s.length();i++){
            
            if (hash.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
