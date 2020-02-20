class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList();
    int target = 0;
        
        for(int i=0;i<nums.length-2;i++){
             if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int partials_sum = target - nums[i];
            int  j=i+1;
            int k = nums.length-1;
            
            while(j<k){
                
                int remain_sum = nums[j]+nums[k];
                if(partials_sum == remain_sum){
                    
                    List<Integer> temp = new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j-1]);
                    do {
                        k--;
                    } while (k > j && nums[k] == nums[k+1]);
                }
                else if(partials_sum>remain_sum){
                    k=k-1;
                }else{
                    j = j+1;
                }
            }
        }
        return result;
    }
}
