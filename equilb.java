import java.util.Scanner;

public class equilb {
  public static void getMaxEqui(int[] arr) {
    int totalSum = 0;
    int leftSum = 0;
    for (int i = 0; i < arr.length; i++) {
      totalSum += arr[i];
    }
    for (int i = 0; i < arr.length; i++) {
      totalSum -= arr[i];
      if (leftSum == totalSum) {
        System.out.println("Equilibrium index is " + i);
      }
      leftSum += arr[i];
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = { 1, 3, 5, 2, 2 };
    getMaxEqui(arr);
    sc.close();
  }
}