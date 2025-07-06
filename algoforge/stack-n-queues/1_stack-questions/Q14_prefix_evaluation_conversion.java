//  haven't done this ques. properly. too many ques. revisit later.
import java.util.Stack;

public class Q14_prefix_evaluation_conversion{

    public static int calculate(int v1, int v2, char ch){
        if(ch == '/'){
            return v1 / v2;
        } else if(ch == '*'){
            return v1 * v2;
        } else if(ch == '-'){
            return v1 - v2;
        } else {
            return v1 + v2;
        }
    }

    public static void prefixConversionAndEvaluation(String prefix){ 
        Stack<Integer> res = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for(int i=prefix.length()-1; i>=0; i--){
            char ch = prefix.charAt(i);

            if(ch == '+' || ch =='-' || ch =='*' || ch=='/'){
                int op1 = res.pop();
                int op2 = res.pop();

                int value = calculate(op1,op2,ch);
                res.push(value);

                String infV1 = infix.pop();
                String infV2 = infix.pop();

                infix.push("(" + infV1 + ch + infV2 + ")");

                String postV1 = postfix.pop();
                String postV2 = postfix.pop();

                postfix.push(postV1 + postV2 + ch);
            } else {
                res.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            }
        }

        System.out.println("Result is " + res.pop());
        System.out.println("Infix expression is " + infix.pop());
        System.out.println("Postfix expression is " + postfix.pop());
    }
    
    public static void main(String[] args) {
        
    }
}