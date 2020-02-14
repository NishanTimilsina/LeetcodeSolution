class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        findCombination(result,0,target,temp,candidates);
        return result;
    }
    
    public void findCombination(List<List<Integer>> result,int index,int target,List<Integer> current,int[] candidates){
        
        if(target == 0){       
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=index;i<candidates.length;i++){
            
            if(candidates[i]>target){
                return;
            }
            current.add(candidates[i]);
            
           findCombination(result,i,target-candidates[i],current,candidates);
            current.remove(current.size()-1);
        }
}
}
