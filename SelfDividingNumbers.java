
//
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> result=new ArrayList();
        
        for(int i=left;i<=right;i++){
            
            boolean isSelf=SelfDivide(i);
            
            if(isSelf){
                result.add(i);
            }
        } 
      return result;
    }
    
    
    public boolean SelfDivide(int i){
        int a=i;
        while(a>0){    
            int b=a%10;
                a=a/10;
                if(b==0 || i%b>0)
                     return false;            
            }
        return true;
}
        
}
