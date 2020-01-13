//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
class Solution {
    public int findNumbers(int[] nums) {
        
        int evenNumber=0;
        
        for(int i=0;i<nums.length;i++){
            
            int count=0;      
            int number=nums[i];
            
            while(number>0){
                number=number/10;
                count=count+1;
            }
            if(count%2==0){
                evenNumber++;
            }
        }
        return evenNumber;
    }
}
