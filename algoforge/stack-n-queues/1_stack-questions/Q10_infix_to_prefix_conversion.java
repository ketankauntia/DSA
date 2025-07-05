// idk

import java.util.Stack;

public class Q10_infix_to_prefix_conversion {

    public static int precedence(char op){
        if(op == '+'){
            return 1;
        } else if(op=='-'){
            return 1;
        } else if(op=='*'){
            return 2;
        } else if(op=='/'){
            return 2;
        }
        return 3;
    }
    
    public static int operation(int v1,int v2, char op){
        if(op == '+'){
            return v1+v2;
        } else if(op=='-'){
            return v1-v2;
        } else if(op=='*'){
            return v1*v2;
        } else if(op=='/'){
            return v1/v2;
        }
        return v1^v2;
    }
    
    public static void infixToPostPre(String exp){
        Stack<Integer> opnds = new Stack<>();   //operators
        Stack<Character> optors = new Stack<>();    //operands

        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);

            if(ch=='('){
                optors.push(ch);
            } else if(Character.isDigit(ch)){
                opnds.push(ch-'0'); //char to integer conv.
            } else if(ch==')'){
                while(optors.peek()!='('){
                    int val2 = opnds.pop();
                    int val1 = opnds.pop();

                    char oprtr = optors.pop();

                    int val = operation(val2, val1, oprtr);
                    opnds.push(val);
                }
                optors.pop();   // to remove this opening bracket as well
            } else if( ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'){
                //ch will wait till the higher priority operator is evaluated before current char is pushed.
                while(!optors.isEmpty() && optors.peek()!='(' && precedence(ch)<precedence(optors.peek())){
                    int val2 = opnds.pop();
                    int val1 = opnds.pop();

                    char oprtr = optors.pop();

                    int val = operation(val2, val1, oprtr);
                    opnds.push(val);
                }
                //operation done, the waiting char of low precedence needs to be pushed now.
                optors.push(ch);    
            }
        }

        while(optors.size()!=0){
            int val2 = opnds.pop();
            int val1 = opnds.pop();

            char oprtr = optors.pop();

            int val = operation(val2, val1, oprtr);
            opnds.push(val);
        }
    }
    public static void main(String args[]){
        
    }
}

