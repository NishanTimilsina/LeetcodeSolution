//https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        
        StringBuilder result = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char c : s.toCharArray()){
            
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        
        PriorityQueue<Character> queue = new PriorityQueue<Character>((a,b)->map.get(b)-map.get(a)); //give you max heap 
        
        for(char c: map.keySet()){
            queue.add(c);
        }
        
        while(!queue.isEmpty()){
            
            char current = queue.remove();
            int currentcharCount = map.get(current);
            
            for(int i=0;i<currentcharCount;i++){
                result.append(current);
            }
        }
        
        return result.toString();
    }
}
