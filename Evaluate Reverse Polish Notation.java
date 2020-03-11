class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> stack = new Stack<String>();
        String operand = "+-/*";
        
        for(String value : tokens){
            
            if(!operand.contains(value)){
                
                stack.push(value);
            }
            else{
                
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                
                switch(value){
                        
                    case "+":{
                        String res = String.valueOf(a+b);
                        stack.push(res);
                        break;           
                        }
                        case "-":{
                        String res = String.valueOf(b-a);
                        stack.push(res);
                        break;
                        
                        }
                        case "*":{
                        String res = String.valueOf(a*b);
                        stack.push(res);
                        break;
                        
                        }
                        case "/":{
                        String res = String.valueOf(b/a);
                        stack.push(res);
                        break;
                        
                        }
                }

                
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
