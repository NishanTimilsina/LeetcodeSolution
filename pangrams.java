import java. util. Arrays;

public class HelloWorld{

     public static void main(String []args){
         //1. first test case
        //String str="A slow yellow fox crawls under the proactive dog";
        
        //2nd test case
        String str="A quick brown fox jumps over the lazy dog";
    
        System.out.println("Result: "+ missingChar(str));
     }
     
     
     public static String missingChar(String myStr){
         
         myStr = myStr.toLowerCase();
         char[] charArray = myStr.toCharArray();
         
         //count array of size 26 which contains the frequency of all alphabets from ‘a’ to ‘z’
         int[] result = new int[26]; 
         
         String finalResult = "";
         
         for(int i=1;i<myStr.length();i++){
             
             //dont take space 
             if(charArray[i] != ' '){
                 
                 result[charArray[i]-'a']++;
             }
         }
         
         //check the frequency of alphabets of result array then if the frequency is ‘0’ that means that the alphabet is not present
         for(int i=0;i<26;i++){
             
             if(result[i]==0){
                 finalResult += (char)(i+'a');
             }
         }
         
         char[] array = finalResult.toCharArray();
         Arrays.sort(array);
         return new String(array);
         
     }
     
     
    

}
