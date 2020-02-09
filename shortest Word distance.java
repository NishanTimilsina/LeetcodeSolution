/******************************************************************************

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

*******************************************************************************/

public class Main
{
	public static void main(String[] args) {
	    
	    String s = "practice makes perfect coding makes";
	    String w1 = "coding";
	    String w2 = "practice";
	    minDistance(s,w1,w2);
	    
		System.out.println("Min distance : "+minDistance(s,w1,w2));
	}
	
	public static int minDistance(String s , String w1, String w2){
	    
	    int min = s.length();
	    
	    String[] strArr = s.split(" ");
	    
	    for(int  i = 0;i <strArr.length;i++){
	        
	        if(w1.equals(strArr[i])){
	            
	            for(int j= 0;j<strArr.length;j++){
	                
	                if(w2.equals(strArr[j])){
	                    
	                    int distance = Math.abs(j-i);
	                    min = Math.min(min,distance);
	                }
	            }
	        }
	    }
	    
	    return min;
	}
}
