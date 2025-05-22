package inheritance;
// V2-ques-complex-no-class

class ComplexNo{
    int real;
    int imaginary;

    public ComplexNo(){
        real = 0;
        imaginary = 0;
    }

    public ComplexNo(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void display(){
        System.out.println(real+"+"+imaginary+"i");
    }

    public void addComplexNo(ComplexNo a){
        this.real = a.real+this.real;
        this.imaginary = a.imaginary + this.imaginary;
        // int imaginary = (a.imaginary * Math.sqrt(-1)) + (b.imaginary * Math.sqrt(-1));
        System.out.println("After Addition: "+this.real+"+"+this.imaginary+"i");
    }
    
    public void multiplyComplexNo(ComplexNo a){
        this.real = a.real*this.real;
        this.imaginary = a.imaginary + this.imaginary;
        // int imaginary = (a.imaginary * Math.sqrt(-1)) * (b.imaginary * Math.sqrt(-1));

        System.out.println("After Multiplication: "+this.real+"+"+this.imaginary+"i");
    }
}

public class V2_ComplexNo{

    public static void main(String[] args){
        ComplexNo a = new ComplexNo();
        a.real=20;
        a.imaginary=2;
        
        ComplexNo b = new ComplexNo(5, 10);

        a.display();
        b.display();

        a.addComplexNo(b);
        a.multiplyComplexNo(b);
    }

}