//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

class Solution {
    public int subtractProductAndSum(int n) {
        int Mnum=n;
        int multiply=1;
        int sum=0;
        
        
        while(n!=0){
            
            sum=sum+n%10;
            multiply = multiply*(n%10);
            n=n/10;
        }
        System.out.println(sum);
        System.out.println(multiply);

        return multiply-sum;
    }
}
