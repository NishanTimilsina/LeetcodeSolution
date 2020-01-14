//https://leetcode.com/problems/defanging-an-ip-address/submissions/

class Solution {
    public String defangIPaddr(String address) {
        
        String resString="";
        for(int i=0;i<address.length();i++){
            
            char current = address.charAt(i);
            if(current=='.'){
               resString += "["+current+"]";  
            }else{
              resString+=current;
            }
        }
        return resString;
    }
}
