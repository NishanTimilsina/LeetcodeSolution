class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        for(int i=0;i<prices.length;i++){
            
            for(int j=i;j<prices.length-1;j++){
                
                if(prices[i]<prices[j+1]){
                    
                    int diff = prices[j+1]-prices[i];
                    max = Math.max(max,diff);
                }
                
            }
        }
        return max;
    }
}
