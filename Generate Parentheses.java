class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList();
        helper(result,"",n,n);
        return result;
    }
    
    public void helper(List<String> res,String current,int left,int right){
        
        if(left<0 || left>right){
            return;
        }
        
        if(left ==0 && right ==0){
            
            res.add(current);
            return;
        }
        helper(res,current+"(",left-1,right);
        helper(res,current+")",left,right-1);
    }
}
