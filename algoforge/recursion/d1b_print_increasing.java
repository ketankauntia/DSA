public class d1b_print_increasing {
    public static void main(String[] args){
        printIncreasing(8);
    }

    public static void printIncreasing(int n){
        if(n==0){
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
}
