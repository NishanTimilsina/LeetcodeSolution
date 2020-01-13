
//https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
        
        HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        int max=0;
        int Rval=0;
        for(int i:nums){

            if(hash.containsKey(i)){
                
              hash.put(i,hash.get(i)+1);
                if(hash.get(i)>max){
                    max=hash.get(i);
                    Rval=i;
                }
                
            }else{
                  hash.put(i,1);
              } 
            
            }
        System.out.println("Element Count : "+hash);
        return Rval;
        }
}
