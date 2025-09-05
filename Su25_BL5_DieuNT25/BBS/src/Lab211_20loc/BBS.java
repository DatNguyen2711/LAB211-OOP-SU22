package Lab211_20loc;


import java.util.Random;
import java.util.Scanner;

public class BBS {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Step 1 : Enter number of array
//        int x = checkInputInt("Enter number of array : ");
        //Step 2 : create random array
//        int []a= randomArray(x);
        //Step 3 : show unsorted array
        int[] a = {5, 1, -5, 12, 16};
        int arrSize = 4;
//        show_unsorted("Unsorted array : ", a);
        do {
            System.out.print("Enter array size: ");
            if (!sc.hasNextInt()) {
                System.out.println("Please enter an integer!!!");
                sc.nextLine();
                continue;
            }
            arrSize = sc.nextInt();
            sc.nextLine();

            if (arrSize <= 1) {
                System.out.println("Arr size must > 1");
            } else {
                break;
            }
        } while (true);
        //Step 4 : use bubble sort algorithm to sort all the elements
        bubbleSort(a);
        //Step 5 : Show the array after sorted
        show_sorted("Sorted array : ", a);
        int[] arr = randomArray(arrSize);
    }

    //check input from user
    static int checkInputInt(String mes) {
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
            } catch (Exception e) {
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


    //create random number < 10
    public static int[] randomArray(int n) {
        //create random nums then add them into array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int ranNum = rand.nextInt(10);
            arr[i] = ranNum;
        }
        return arr;
    }


    // print the array
    static void show_unsorted(String mes, int a[]) {
        System.out.print(mes);
        System.out.print("[");
        //loop through the array to display it's elements
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[a.length - 1] + "]");
    }

    static void printarr_bbs(int[] a) {
        System.out.print("[");
        //loop through the array to display it's elements
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[a.length - 1] + "] ");

    }

    //sort the elements in array by bubble sort algorithm
    static void bubbleSort(int[] a) {
        /*Loop use to accessed from the first to last element of array,
        after each loop, one element is sorted,the biggest sorted element will be stand in the last of array*/
        for (int i = 0; i < a.length; i++) {
            System.out.println("");
            /*Loop use to accessed first unsorted element to the element stand
            before the last unsorted element*/
            for (int j = 0; j < a.length - i - 1; j++) {
                printarr_bbs(a);
                //compare adjacent elements
                if (a[j] > a[j + 1]) {
//                    System.out.println(": " + a[j] + ">" + a[j + 1] + ", SWAP");
//                    int temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
                    a[j] = a[j] + a[j + 1];
                    a[j + 1] = a[j] - a[j + 1];
                    a[j] = a[j] - a[j + 1];

                    /*a[j] = 5, a[j+1] = 7
                        B1: a[j] = 5 + 7 = 12
                        B2: a[j+1] = 12 - 7 = 5
                        B3: a[j] = 12 - 5 = 7
                        => Đã đổi chỗ
                        */
                } else {
                    System.out.println(": " + a[j] + "<" + a[j + 1] + ", ok");
                }
            }
        }
    }


    // display the array after sorted
    static void show_sorted(String mes, int[] a) {
        System.out.printf("\n");
        System.out.print(mes);
        System.out.print("[");
        //loop through the array to display it's elements
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[a.length - 1] + "]");
    }
}


// a=6 b =1 a = a+b =7 b = a -b =6 a =a-b