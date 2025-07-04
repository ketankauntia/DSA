// https://www.geeksforgeeks.org/problems/fun-with-expresions2523/1

import java.util.Stack;


// without parentheses ( this will work on gfg)
public class Q8_infix_evaluation {
    public int calculate(String s) {
        // Code here
        Stack<Integer> st = new Stack<>();
        int num=0;
        char sign = '+';

        for(int i=0 ; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num* 10+(ch - '0');
            }

            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(sign == '+') st.push(num);
                else if (sign == '-') st.push(-num);
                else if (sign == '*') st.push(st.pop() * num);
                else if (sign == '/') st.push(st.pop() / num);

                sign = ch;
                num = 0;
            }
        }

        int res = 0;
        while(!st.isEmpty()){
            res+=st.pop();
        }

        return res;
    }
}

// for code with parentheses ( more complex hai ye.)

public int calculate(String s) {
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();
    int n = s.length();

    for (int i = 0; i < n; ) {
        char ch = s.charAt(i);

        if (ch == ' ') {
            i++;
            continue;
        }

        if (Character.isDigit(ch)) {
            int num = 0;
            while (i < n && Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            operands.push(num);
        } else if (ch == '(') {
            operators.push(ch);
            i++;
        } else if (ch == ')') {
            while (operators.peek() != '(') {
                evaluateTop(operands, operators);
            }
            operators.pop(); // remove '('
            i++;
        } else if (isOperator(ch)) {
            while (!operators.isEmpty() &&
                    precedence(operators.peek()) >= precedence(ch)) {
                evaluateTop(operands, operators);
            }
            operators.push(ch);
            i++;
        }
    }

    while (!operators.isEmpty()) {
        evaluateTop(operands, operators);
    }

    return operands.pop();
}

void evaluateTop(Stack<Integer> operands, Stack<Character> operators) {
    int b = operands.pop();
    int a = operands.pop();
    char op = operators.pop();
    operands.push(applyOp(a, b, op));
}

boolean isOperator(char ch) {
    return ch == '+' || ch == '-' || ch == '*' || ch == '/';
}

int precedence(char op) {
    if (op == '+' || op == '-') return 1;
    if (op == '*' || op == '/') return 2;
    return 0;
}

int applyOp(int a, int b, char op) {
    if (op == '+') return a + b;
    else if (op == '-') return a - b;
    else if (op == '*') return a * b;
    else return a / b;
}