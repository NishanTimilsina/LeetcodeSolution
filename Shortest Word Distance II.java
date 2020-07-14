public class HelloWorld{

     public static void main(String []args){
         
         //Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
         String[] words = {"practice", "makes", "perfect", "coding", "makes"};
         String word1 = "makes";
         String word2 = "coding";
         
         
         int minDistance = Integer.MAX_VALUE;
         int pos1= -1;
         int pos2 = -1;
         
         for(int i=0;i<words.length;i++){
             
             if(words[i].equals(word1)){
                 pos1 = i;
             }
             if(words[i].equals(word2)){
                 pos2= i;
             }
             
             if(pos1 != -1 && pos2 != -1){
                 
                 minDistance = Math.min(minDistance,Math.abs(pos1-pos2));
             }
         }
                 System.out.println("result: "+minDistance);

         
     }
}
