package LinearSearch_50LOC;

import java.util.Random;
import java.util.Scanner;

public class LS {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Enter number for array
        int x = checksizearray("Enter number of array : ");
        //Create random array
        int []a=randomnumber(x);
        //Enter the value want to find
        int c = checkInputvalue("Enter value you want to find : ");
        //display the array
        show_arr("The array : ",x,a);
        //search the index of value want to find in array
        linear_search(x,a,c);
    }

    //check input from user
    static int checksizearray(String mes){
        System.out.println(mes);
        int choice = 0;
        boolean cout =false;
        while (cout=true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice < 1) {
                    System.out.println("Number must be > 0!!!");
                    cout=true;
                }
            } catch (Exception e) {
                System.out.println("Please enter an integer!!!");
                cout=true;
            }
            if (choice > 0) {
                break;
            }
            else
                System.out.println("Enter number again!!!");
        }
        return choice;
    }

    static int checkInputvalue(String mes){
        System.out.println(mes);
        int choice = 0;
        boolean cout =false;
        while (cout=true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice >= 0) break;
            } catch (Exception e) {
                System.out.println("Please enter an integer!!!");
                cout=true;
            }
            if(choice < 0){
                System.out.println("Value must > 0 !!! Enter again");
                cout=true;
            }
        }
        return choice;
    }
    static int[] randomnumber(int x){
        //create random nums then add them into array
        int []arr=new int[x];
        for (int i=0; i<x; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(10);
            arr[i]=ranNum;
        }
        return arr;
    }

    static void show_arr(String mes,int x, int a[]){
        System.out.print(mes);
        System.out.print("[");
        //loop through the array to display it's elements
        for(int i=0;i<x-1;i++){
            System.out.print(a[i]+", ");
        }
        System.out.println(a[x-1]+ "]");
    }

    static void linear_search(int x,int []a,int c){
        int same = 0;
        int dif=0;
        // loop through the array to the end
        for(int i = 0; i <x;i++){
            // compare each element in array to the value you want to know
            if(c == a[i]) {
                same++;
                if(same == 1){
                    System.out.print("Found "+c+" at index : " +i);
                }else{
                    System.out.print(", " +i);
                }
            }else if(c!=a[i]){
                dif++;
            }
        }
        // if count equal to the lenght of array it show that the value we want to find does not appear in array
        if(dif == x){
            System.out.println("This value does not appear in array");
        }
    }
}
