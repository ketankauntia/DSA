// https://leetcode.com/problems/implement-stack-using-queues/description/

// package algoforge.stack-n-queues.3_Adaptors;

import java.util.LinkedList;

class Stack{
    LinkedList<Integer> dataQue;

    public Stack(){
        dataQue = new LinkedList<>();
    }

    public void push(int value){    // O(1)
        dataQue.addLast(value);
    }
    
    public int peek(){  // O(n)
        LinkedList<Integer> newDataQue = new LinkedList<>();

        while(dataQue.size() > 1){
            int removeValue = dataQue.removeFirst();
            newDataQue.addLast(removeValue);
        }

        int peekValue = dataQue.getFirst();
        newDataQue.add(peekValue);

        dataQue = newDataQue;
        return peekValue;
    }
    
    public int pop(){
        LinkedList<Integer> newDataQue = new LinkedList<>();

        while(dataQue.size() > 1){
            int removeValue = dataQue.removeFirst();
            newDataQue.addLast(removeValue);
        }

        int peekValue = dataQue.removeFirst();;

        dataQue = newDataQue;
        return peekValue;
    }
    
    public int size(){
        return dataQue.size();
    }

    public boolean empty() {
        if(dataQue.size()<=0){
            return true;
        }
        return false;
    }
}

public class Q1_StackUsingQueuePushEfficient {
    
}
