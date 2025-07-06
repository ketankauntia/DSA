// https://www.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1

class twoStacks {
    int n = 100;
    int arr[];

    int ptr1;
    int ptr2;
    
    twoStacks() {
        arr = new int[n];
        ptr1=-1;
        ptr2=arr.length;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        arr[++ptr1]=x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        arr[--ptr2]=x;
    }

    // Function to remove an element from top of the stack1. 
    int pop1() {
        if (ptr1 == -1){
            return -1;   // underflow is not guaranteed. so..
        }
        --ptr1;
        return arr[ptr1+1];
    }

        
    // Function to remove an element from top of the stack2.
    int pop2() {
        if (ptr2 == arr.length){
            return -1;   // underflow is not guaranteed. so..
        }
        ++ptr2;
        return arr[ptr2-1];
    }
}

public class Q13_two_stacks {
    public static void main(String[] args) {
        
    }
}
