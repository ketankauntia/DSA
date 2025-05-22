package abstraction;
// must implement in child for whatever defined in abstract class

abstract class Shape {
    int numberOfSides;

    abstract public double getArea();

    public void print(){
        System.out.println("Printing");
    }
}

class Circle extends Shape{
    int radius;

    public Circle(int radius){
        super.numberOfSides = 0;
        this.radius = radius;
    }

    public double getArea(){
        return 3.14*this.radius*this.radius;
    }
}

class Main {
    public static void main(String[] args){
        Circle s = new Circle(4);
        System.out.println(s.getArea());
        s.print();
    }
}