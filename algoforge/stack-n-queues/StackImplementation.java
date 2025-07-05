// https://www.geeksforgeeks.org/problems/implement-stack-using-array/1

// package algoforge.stack-n-queues;

//static stack : stack of fixed size.
//dynamic stack: during push, if size is full, we double the size. (simple)


class Stack{
    int maxSize = 10;
    int arr[] = new int[maxSize];
    int i=-1;
    
    // Custom constructor
    // Stack(int capacity) {
    //     this.maxSize = capacity;
    //     this.arr = new int[maxSize];
    //     this.i = -1;
    // }

    public int peek(){
        if(i<0){
            System.out.println("underflow");
            return -1;
        }
        return arr[i];
    }
    public int pop(){
        if(i<0){
            System.out.println("underflow");
            return -1;
        }
        --i;
        return arr[i+1];
    }

    public void push(int value){
        if(i>=maxSize-1){
            System.out.println("overflow");
            return;
        }
        ++i;
        arr[i]=value;
    }

    public int size(){
        if(i==-1){
            return -1;
        }
        return i+1;
    }
}

public class StackImplementation {
    public static void main(String[] args) {
        Stack st = new Stack();

        st.push(2);
        st.push(23);

        System.out.println(st.peek());
    }
}
