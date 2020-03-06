import java.io.*;
import java.util.*;

/*

1.
@@@@@
@   @
@   @
@@@@@.

2.
    * 
   * * 
  * * * 
 * * * * 
* * * * * 


3.

*
* *
* * *
* * * *
* * * * *


4.

* * * * *
* * * *
* * * 
* *
*

 */

class Solution {
  public static void main(String[] args) {

   PrintRect(5,4);
   print2Triangle(5);
  print3rdTriangle(5);
   print4rdTriangle(6);
    
  }
  
    public static void print2Triangle(int n){
  
     int rows = n, k = 0;

        for(int i = 1; i <= rows; i++,k=0) {
          
            for(int j = 1; j <= rows - i; j++) {
              
                System.out.print("  ");
            }

            while(k != 2 * i - 1) {
                System.out.print("* ");
                k++;
            }

           System.out.println();
      
    }
    
  }
  
  public static void print4rdTriangle(int n){
  
    for(int i=n;i>0;i--){
    
      System.out.println();
      
      for(int j=0;j<i;j++){
      
        System.out.print("*");
      }
      
    }
    
  }
  
  public static void print3rdTriangle(int n){
  
    for(int i=0;i<n;i++){
    
      System.out.println();
      
      for(int j=0;j<i;j++){
      
        System.out.print("*");
      }
      
    }
    
  }
  
  
  public static void PrintRect(int w,int h){
  
    for(int i=0;i<h;i++){
    
      System.out.println();
      
      for(int j=0;j<w;j++){
      
        if(i==0 || j== 0 || i == h-1 || j == w-1){
        
          System.out.print("@");
        }else{
        System.out.print(" ");
        }
      }
    }
  }
}

