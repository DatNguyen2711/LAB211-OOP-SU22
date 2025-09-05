package Fibo45;

public class Main {
    public static void main(String[] args) {
        display_fibo(45);
    }

    static void display_fibo(int n){
        for (int i = 0; i < n-1; i++) {
            System.out.print(fibonacci(i)+ ", ");
        }
        System.out.print(fibonacci(n-1));
    }


    static int fibonacci(int n) {
        int f0 = 0;
        int f1 = 1;
        int fn = 1;
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
