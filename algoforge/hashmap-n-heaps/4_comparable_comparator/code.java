// package algoforge.hashmap-n-heaps.4_comparable_comparator;
import java.util.*;
public class code {

    static class Student implements Comparable<Student>{
        int rno;
        int ht;
        int wt;

        Student(int rno, int ht, int wt){
            this.rno = rno;
            this.ht = ht;
            this.wt = wt;
        }
        
        public int compareTo(Student o){
            return this.rno - o.rno;        // ascending
            // return o-rno - this.rno;     // descending
        }

        public String toString(){
            return "Rno =" +this.rno+", Ht = "+this.ht+", Wt = "+this.wt;
        }
    }

    public static void main(String[] args) {
        
    }
}
