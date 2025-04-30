public class d1c_print_inc_dec {
    public static void main(String[] args) {
        printIncDec(5);
    }
    public static void printIncDec(int n) {
        if(n==1){
            System.out.println(1);
            return;
        }
        System.out.println(n);
        printIncDec(n-1);
        System.out.println(n);
    }
}
