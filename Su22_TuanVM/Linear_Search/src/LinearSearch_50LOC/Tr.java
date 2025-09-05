package LinearSearch_50LOC;

import java.util.Scanner;

public class Tr {

    static int fun(int a,int n){
        if(n==0) return(1);
        int t = fun(a,n/2);
        if(n%2==0){
            return(t*t);
        }else{
            return(t*t*a);
        }



   }
    public static void main(String[] args) {
        fun(3,2);
    }
}

