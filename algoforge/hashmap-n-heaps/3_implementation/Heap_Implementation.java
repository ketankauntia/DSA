import java.util.*;

public class Heap_Implementation {
    public static class PriorityQueue{
        ArrayList<Integer> data;

        public PriorityQueue(){
            data = new ArrayList<>();
        }

        public void add(int val){
            //add to the end of tree
            data.add(val);

            upheapify(data.size() - 1);
        }

        private void upheapify(int i){
            if(i==0){
                return;
            }
            int pi = (i-1)/2;   // parent index
            if(data.get(pi)>data.get(i)){
                swap(i,pi);
                upheapify(pi);
            }
        }

        private void swap(int i, int j){
            int ith = data.get(i);
            int jth = data.get(j);

            data.set(i, jth);
            data.set(j, ith);
        }

        public int remove(){
            if(this.size()==0){
                System.out.println("underflow");
                return -1;
            }
            swap(0, data.size()-1);
            int val = data.remove(size()-1);
            downheapify(0);
            return val;
        }


        // what we did in this was, compare the parent index ka value with left side value first.
        // then compare the winner of teh above with the right side.
        // we are noting the "index" of whoever wins.
        // finally we swap the values at the indexes if required to swap.
        public void downheapify(int pi){
            int mini = pi;

            int li = 2 * pi + 1;
            if(li<data.size() && data.get(li)<data.get(mini)){
                mini= li;
            }
            int ri = 2 * pi + 2;
            if(ri<data.size() && data.get(ri)<data.get(mini)){
                mini= ri;
            }
            if(mini != pi){
                swap(pi, mini);
                downheapify(mini);
            }
        }

        public int peek(){
            if(this.size()==0){
                System.out.println("underflow");
                return -1;
            }
            return data.get(0);
        }
        
        public int size(){
            return data.size();
        }
    }    
}

