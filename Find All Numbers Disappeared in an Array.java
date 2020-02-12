class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> missing = new ArrayList();
        HashSet<Integer> hash = new HashSet<Integer>();
        
        for(int n: nums){
            
            hash.add(n);
        }
        
        for(int i=1;i<=nums.length;i++){
            
            if(!hash.contains(i)){
                missing.add(i);
            }
        }
        return missing;
    }
}
