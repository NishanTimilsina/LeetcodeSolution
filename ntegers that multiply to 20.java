/******************************************************************************

Find integers that multiply to 20

*******************************************************************************/
import java.util.HashMap; 
import java.util.Map;

public class Main
{
	public static void main(String[] args) {
	    int[] number = {2,4,1,6,5,40,-1};
	    
	    
	    HashMap<Integer,Integer> hash = new HashMap();
	    
	    for(int i=0;i<number.length;i++){
	        
	        hash.put(number[i],i);
	    }
	    
	    
	    for(int i=0;i<number.length;i++){
	        
	        int value = 20/number[i];
	        
	        if(hash.containsKey(value)){
	            
	            System.out.println(number[i]);
	            System.out.println(value);
	            break;
	        }
	    }
	    
	   // for(int i=0;i<number.length;i++){
	        
	   //     for(int j=i+1;j<number.length;j++){
	            
	            
	   //         if((number[i]*number[j])==20){
	   //           System.out.println(number[i]);
	   //           System.out.println(number[j]);
  
	   //         }
	   //     }
	    //}
	    
	}
}
