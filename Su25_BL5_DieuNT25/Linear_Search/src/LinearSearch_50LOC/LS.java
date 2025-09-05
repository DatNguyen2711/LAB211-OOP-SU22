package LinearSearch_50LOC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LS {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> indexList = new ArrayList<>();

    public static void main(String[] args) {
        //Enter number for array
        int x = checksizearray("Enter number of array : ");
        //Create random array
        int[] a = randomnumber(x);
        //Enter the value want to find
        int c = checkInputvalue("Enter value you want to find : ");
        //display the array
        show_arr("The array : ", x, a);
        //search the index of value want to find in array
        linear_search(x, a, c);
    }

    //check input from user
    static int checksizearray(String mes) {
        System.out.println(mes);
        int choice = 0;
        boolean cout = false;
        while (cout = true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1) {
                    System.out.println("Number must be > 0!!!");
                    cout = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer!!!");
                cout = true;
            }
            if (choice > 0) {
                break;
            } else
                System.out.println("Enter number again!!!");
        }
        return choice;
    }

    static int checkInputvalue(String mes) {
        System.out.println(mes);
        int choice = 0;
        boolean cout = false;
        while (cout = true) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 0) break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer!!!");
                cout = true;
            }
            if (choice < 0) {
                System.out.println("Value must > 0 !!! Enter again");
                cout = true;
            }
        }
        return choice;
    }

    static int[] randomnumber(int x) {
        //create random nums then add them into array
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(10);
            arr[i] = ranNum;
        }
        return arr;
    }

    static void show_arr(String mes, int x, int a[]) {
        System.out.print(mes);
        System.out.print("[");
        //loop through the array to display it's elements
        for (int i = 0; i < x - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[x - 1] + "]");
    }

    static void linear_search(int x, int[] a, int c) {
        indexList.clear(); // Xoá list cũ nếu có dữ liệu trước đó

        // loop through the array
        for (int i = 0; i < x; i++) {
            if (c == a[i]) {
                indexList.add(i); // Thêm index vào list
            }
        }

        // Kiểm tra và hiển thị kết quả
        if (indexList.isEmpty()) {
            System.out.println("This value does not appear in array");
        } else {
            System.out.println("Found " + c + " at index: " + indexList);
        }
    }

}
