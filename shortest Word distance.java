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



//******************* Effective solution Big o(n)************

public class HelloWorld{

     public static void main(String []args){
         
         
        String[] words = {"practice","makes","perfect","coding","makes"};
 
        String word1 = "coding";
        String word2 = "practice";
        
        int result = shortestDistance(words,word1,word2);
        
        System.out.println("Shortest Distance: "+ result);
     }
     
     /// Big O(n)
     public static int shortestDistance(String[] words,String word1,String word2){
         
         
         int left = -1;
         int right = -1;
         
         int shortDistance = words.length;
         
         for(int i= 0;i<words.length;i++){
             
             if(word1.equals(words[i])){
                 
                 left = i;
             }
             if(word2.equals(words[i])){
                 right  = i;
             }
             
             if(left>=0 && right>=0){
                 
             shortDistance = Math.min(shortDistance,Math.abs(right-left
             
             ));
             }
             
         }
         
         return shortDistance;
         
         
     }

}
