package Fibo45;

public class Fibo_45 {
    public static void main(String[] args) {
        //Display 45 fibonacci number
        displayFibonacci();
    }
    private static void displayFibonacci() {
        int count =0;
        System.out.println("The 45 fibonacci: ");
        //calculate fibonacci
        Fibonacci(45,0,1,count);
    }
    private static int Fibonacci(int i, int f0, int f1, int count) {
        count++;
        //check enough 45 number
        if(i<1) {
            return f1;
        }
        System.out.print(f0);
        System.out.print("("+count+")");
        //check number is the last number
        if(i>1){
            System.out.print(", ");}
        return Fibonacci(i-1, f1, f0+f1, count);
    }
}
