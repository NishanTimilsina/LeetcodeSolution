class Solution {
    //num1=125
    //num2 = 456
    //result = 581
    
    public String addStrings(String num1, String num2) {
       
        StringBuilder result= new StringBuilder();
        int n1= num1.length()-1;
        int n2 = num2.length()-1;
        int carry=0;
        while(n1>=0 || n2>=0){
            
            int sum = carry;
            
            if(n1>=0){
                sum += num1.charAt(n1)-'0';
                System.out.println(sum);
                n1--;
            }
            if(n2>=0){
                sum +=num2.charAt(n2)-'0';
                n2--;
            }
                result.append(sum%10);
                carry = sum/10;               
            }

        if(carry!=0){
        result.append(carry);
        }
        return result.reverse().toString();

    }
}
