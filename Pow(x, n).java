class Solution {
    public double myPow(double x, int n) {
     
      //System.out.println(pow(x,n));  
        
      return pow(x,n);
    }
    
    public double pow(double x,int n){
        
        if(n==0){
            return 1;
        }
        if(n%2==0){
            return pow(x,n/2)*pow(x,n/2);
        }else{
            return x * pow(x,n/2) * pow(x,n/2);
        }
    }
}
