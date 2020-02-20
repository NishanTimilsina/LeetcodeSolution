class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> result = new ArrayList();
         List<Integer>[] list = new List[nums.length+1];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int num:nums){
            
            if(hash.containsKey(num)){
                
                hash.put(num,hash.get(num)+1);
            }else{
                
                hash.put(num,1);
            }

        }
        
        for(int value : hash.keySet()){
            
            int frequency = hash.get(value);
            
            if(list[frequency]==null){
                list[frequency] = new ArrayList();
            }       
            
            list[frequency].add(value);
            
        }
        System.out.println(Arrays.toString(list));

		for (int pos = list.length - 1; pos >= 0 && result.size() < k; pos--) {
			if (list[pos] != null) {
                result.addAll(list[pos]);
			}
		}
        return result;
    }
}
