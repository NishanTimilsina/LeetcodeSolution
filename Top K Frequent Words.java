class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> hash = new HashMap<String,Integer>();
        List<String> result = new ArrayList();
        
        for(int i=0;i<words.length;i++){
            
            String value = words[i];
            if(hash.containsKey(value)){
                hash.put(value,hash.get(value)+1);
            }else{
                hash.put(value,1);
            }
        }
        
        List<String>[] bucket = new List[words.length+1];
        
        for(String s:hash.keySet()){
            
            int frequency = hash.get(s);
            
            if(bucket[frequency]==null){
                
                bucket[frequency] = new ArrayList();
            }
            bucket[frequency].add(s);
            
            System.out.println("key: "+hash.get(s) + " value:"+s);
        }
        System.out.println(Arrays.toString(bucket));
        
        for(int i=bucket.length-1;i>=0;i--){
            
        if(bucket[i]!=null){
            
            Collections.sort(bucket[i]);
            
            for(int j=0;j<bucket[i].size(); i++){
                
                result.add(bucket[i].get(j));
            }
        }
        }
        return result;
    }
}
