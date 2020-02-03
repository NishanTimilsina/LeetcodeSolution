class Solution {
    public boolean judgeCircle(String moves) {
        
        boolean result = countMoves(moves);
        return result;
    }
    
    public boolean countMoves(String moves){
        
        int countUp=0;
        int countDown = 0;
        int countLeft = 0;
        int countRight = 0;
        
        for(int i=0;i<moves.length();i++){
            
            if(moves.charAt(i)=='U'){
                countUp++;
            }
            if(moves.charAt(i)=='D'){
                countDown++;
            }
            if(moves.charAt(i)=='L'){
                countLeft++;
            }
            if(moves.charAt(i)=='R'){
                countRight++;
            }
        }
        
        if(countDown-countUp==0 && countRight-countLeft ==0){
            return true;
        }
        return false;
    }
}
