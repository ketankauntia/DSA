// package algoforge.stack-n-queues;

//static queue
class Queue{
    private int maxSize = 10;
    private int front;
    private int size;
    private int[] data;

    public Queue(){
        front = 0;
        size = 0;
        data = new int [maxSize];
    }

    public void add(int value){
        if(size == maxSize){
            System.out.println("Queue overflow!");
            return;
        }
        int idx = (front+size) % data.length;
        data[idx] = value;
        size++;
    }

    public int remove(){
        if(size == 0){
            System.out.println("Queue Empty!");
            return -1;
        }
        int frontValue = data[front];
        front = (front+1)%data.length;
        size--;

        return frontValue;
    }

    public int peek(int value){
        if(size == 0){
            System.out.println("Queue empty!");
            return -1;
        }
        return data[front];
    }
    
    public int size(){
        return size;
    }

    public void display(){
        for(int idx =0;idx<size; idx++){
            System.out.print(data[(front+idx)%data.length]);
        }
        System.out.println();
    }
}


public class QueueImplementation {
    public static void main(String[] args) {
        
    }
}


// dynamic queue

public void add(int value){
    if(size== data.length){
        int[] newData = new int[data.length*2];
        for(int i =0;i<size;i++){
            int idxForOldData = (front + i) % data.length;
            newData[i] = data[idxForOldData];
        }
        data = newData;
        front = 0;
    }

    int idx= (front + back) % data.length;
    data[idx] = value;
    size++;
}