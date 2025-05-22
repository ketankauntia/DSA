package encapsulation;

class Student{
    int rollNo;
    private int marks;

    public Student(int rollNo, int marks){
        this.rollNo=rollNo;
        this.marks=marks;
    }
    //getter fn
    public int getMarks(){
        return this.marks;
    }

    //setter fn
    public void setMarks(int marks){
        this.marks=marks;
    }
}

public class Question {
    public static void main(String[] args) {
        Student s1 = new Student(221, 10);
        
        int val = s1.getMarks();
        System.out.println(val);
        
        s1.setMarks(50);

        val = s1.getMarks();
        System.out.println(val);
    }
}
