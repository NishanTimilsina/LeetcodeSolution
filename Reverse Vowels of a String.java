class Solution {
    public String reverseVowels(String s) {
        
        
        int j=0;
        String vString  = "";
        char[] res = s.toCharArray();
        for(int i=0;i<s.length();i++){
            
            if(isVowel(s.charAt(i))){
                j++;
                vString +=s.charAt(i);
            }
        }
               
    for(int k=0;k<s.length();k++){
        
        if(isVowel(s.charAt(k))){
           res[k] = vString.charAt(--j);
            
        }
                   
    }
           return new String(res);
    }
               
    public boolean isVowel(Character c){
        
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }
}
