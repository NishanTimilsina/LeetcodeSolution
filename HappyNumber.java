//https://leetcode.com/problems/happy-number/

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while(n!=1){    
            int current = n;
            int sum=0;       
            while(current!=0){       
                sum+= (current%10)*(current%10);
                current=current/10;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            n=sum;            
        }
        return true;
    }
}
