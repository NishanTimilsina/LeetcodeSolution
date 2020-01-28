//https://leetcode.com/problems/unique-number-of-occurrences/

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        
        for(int i=0;i<arr.length;i++){
              
            if(hash.containsKey(arr[i])){
                
                hash.put(arr[i],hash.get(arr[i])+1);
            }else{
                hash.put(arr[i],1);
            }             
        }
        //print
        hash.forEach((k,v)-> System.out.println(k+","+v));
        
        List<Integer> res = new ArrayList();
        
        for(int val:hash.values()){
            
            if(res.contains(val)){
                return false;
            }
            res.add(val);
        }     
        return true;
    }
}
