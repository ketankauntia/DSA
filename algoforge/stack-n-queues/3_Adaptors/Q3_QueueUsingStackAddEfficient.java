// https://leetcode.com/problems/implement-queue-using-stacks/

import java.util.Stack;

class Queue{
    Stack<Integer> dataStack;
    
    public Queue(){
        dataStack = new Stack<>();
    }

    public void push(int value){  // O(1)
        dataStack.push(value);
    }

    public int pop(){

        //make a new stack, put values into it, then pop from the new stack
        // this pop from new stack not req. we will remove all values from old stack till before the last element.
        // pop the last value and store it. ( saves 1 operation )

        Stack<Integer> newDataStack = new Stack<>();
        while(dataStack.size() > 1){
            newDataStack.push(dataStack.pop());
        }
        int popVal = dataStack.pop();
        
        // now we transfer the values back to the old stack to maintain the order
        while(newDataStack.size() > 0){
            dataStack.push(newDataStack.pop());
        }

        return popVal;
    }

    public int peek(){
        Stack<Integer> newDataStack = new Stack<>();

        while(dataStack.size()>1){
            newDataStack.push(dataStack.pop());
        }
        int peekValue = dataStack.pop();
        dataStack.push(peekValue);

        while(newDataStack.size()>0){
            dataStack.push(newDataStack.pop());
        }

        return peekValue;
    }
    
    public boolean empty(){
        return dataStack.size()>0 ? false : true;
    }

    public int size(){
        return dataStack.size();
    }
}

public class Q3_QueueUsingStackAddEfficient {
    public static void main(String[] args) {
        
    }
}
