import java. util. Arrays;
import java.util.*;

public class HelloWorld{

     public static void main(String []args){
         //1. first test case
        //String str="A slow yellow fox crawls under the proactive dog";
        
        //2nd test case
        String str="zero;two;five;seven;eight;four";
    
        System.out.println("Result: "+ wordToNumber(str));
     }
     
    public static String wordToNumber(String strings){
        
        //create arrays of string separate by semi colon
        String[] myStr = strings.split(";");
        
        String result = "";
        
        //create dictionary to find the number  from zero to nine
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);
        
        //check each string in the dictionary if yes then append into result
        for(String str: myStr){
            
            if(map.containsKey(str)){
                result += String.valueOf(map.get(str));
            }
        }
        return result;
    }
     
     
    

}
