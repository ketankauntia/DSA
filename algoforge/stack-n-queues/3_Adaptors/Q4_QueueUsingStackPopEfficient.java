import java.util.Stack;

class Queue{
    Stack<Integer> ds;  //dataStack
    
    public Queue(){
        ds = new Stack<>();
    }

    public void push(int value){
        Stack<Integer> nds = new Stack<>(); //newDataStack
        while(ds.size()>0){
            nds.push(ds.pop());
        }
        ds.push(value);
        while(nds.size()>0){
            ds.push(nds.pop());
        }
    }

    public int pop(){  // O(1)
        return ds.pop();
    }

    public int peek(){  // O(1)
        return ds.peek();
    }
    
    public boolean empty(){
        return ds.size()>0 ? false : true;
    }

    public int size(){
        return ds.size();
    }
}

public class Q4_QueueUsingStackPopEfficient {
    public static void main(String[] args) {
        
    }
}