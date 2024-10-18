import java.util.Scanner;

public class leader {
    public static void leader1(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1];
        System.out.println(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                System.out.println(max);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = { 5, 3, 1, 2, 0 };
        leader1(arr);
        sc.close();
    }
}