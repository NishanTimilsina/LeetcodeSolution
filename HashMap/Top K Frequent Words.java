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
            
        if(bucket[i] != null){
            
            Collections.sort(bucket[i]);
            
            for(int j=0;j<bucket[i].size() && result.size()<k; i++){
                
                result.add(bucket[i].get(j));
            }
        }
        }
        return result;
    }
}


///****************** compile code

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length == 0) {
            return new ArrayList<String>();
        }

        Map<String, Integer> map = new HashMap();
        for (String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String>[] bucket = new List[words.length + 1];
        for (Map.Entry<String, Integer> set : map.entrySet()) {
            int frequecny = set.getValue();
            if (bucket[frequecny] == null) {
                bucket[frequecny] = new ArrayList<>();
            }
            bucket[frequecny].add(set.getKey());
        }

        List<String> rst = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                // Sort the string to meeting demand.
                Collections.sort(bucket[i]);
                // We can use addAll method to avoid adding too much elements (exceeding k).
                for (int j = 0; j < bucket[i].size() && rst.size() < k; j++) {
                    rst.add(bucket[i].get(j));
                }
            }
        }
        return rst;
    }
}
