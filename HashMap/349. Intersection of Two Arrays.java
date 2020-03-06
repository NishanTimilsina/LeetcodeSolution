//https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i: nums1){
            
            set.add(i);
        }
        
       HashSet<Integer> intersect = new HashSet<Integer>();

        for(int j: nums2){
            
            if(set.contains(j)){
                intersect.add(j);
            }
        }
        
        int[] res = new int[intersect.size()];
        int index = 0;
        
        for(int val : intersect){
            res[index++] = val;
        }
        return res;
    }
}
