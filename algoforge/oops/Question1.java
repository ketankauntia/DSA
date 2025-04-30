// Learning Constructor + constructor chaining.

class Bike {
    String engineType;
    String color;
    int horsepower = 100;

    public Bike(String engineType, String color, int horsepower){
        this.engineType=engineType;
        this.color= color;
        this.horsepower= horsepower;
    }

    public void color_change(String color){
        this.color = color;
        System.out.println("Color Changed to :"+ color);
    }

    public void double_horsepower(){
        this.horsepower = 2*this.horsepower;
        System.out.println("Horsepower doubled to :"+ this.horsepower);
    }
}

class Question1{
    public static void main(String args[]){
        Bike b = new Bike("V8","Red",200);

        System.out.println(b.color);
        System.out.println(b.engineType);
        System.out.println(b.horsepower);
        
        b.double_horsepower();
        b.color_change("black");
        
        System.out.println(b.color);
        System.out.println(b.engineType);
        System.out.println(b.horsepower);

    }
}