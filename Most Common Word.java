class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        String parag = paragraph.toLowerCase();
        String[] p1 = parag.split(" ");
        String res = "";  
        int max = 0;
        
        for(int i=0;i<p1.length;i++){
            
            String value = p1[i].replaceAll("[^a-zA-Z]","");
            
            if(!isBanned(banned,value)){
            if(hash.containsKey(value)){
                
                hash.put(value, hash.get(value)+1);
            }else{
                hash.put(value,1);
            }
        }
        }
        
      for(String s : hash.keySet()){
          
          if(hash.get(s)>max){
              max = hash.get(s);
              res = s;
          }
      }
        
        return res;
    }
               
      public boolean isBanned(String[] banned,String word){
          
          for(int i=0;i<banned.length;i++){
              
              if(word.equals(banned[i])){
                  return true;
              }
          }
          return false;                
    }
}
