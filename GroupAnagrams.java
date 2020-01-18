//https://leetcode.com/problems/group-anagrams/submissions/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> group = new ArrayList<>();
        
        HashMap<String,List<String>> map = new HashMap<>();
        
        for(String str: strs){
            
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            
            if(!map.containsKey(newStr)){
                map.put(newStr,new ArrayList<>());
            }
            map.get(newStr).add(str);
            
        }
        group.addAll(map.values());
        return group;
        
    }
}
