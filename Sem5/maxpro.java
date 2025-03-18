import java.util.Scanner;

public class maxpro {
  public static int maxprod(int a[]) {
    int n = a.length;
    int maxP = a[0];
    int max = a[0], temp = 0, min = a[0];
    for (int i = 1; i < n; i++) {
      if (a[i] > 0) {
        max = Math.max(a[i] * max, a[i]);
        min = Math.min(a[i] * min, a[i]);
      } else if (a[i] == 0) {
        max = min = 0;
      } else {
        temp = max;
        max = Math.max(a[i] * min, a[i]);
        min = Math.min(a[i] * temp, a[i]);
      }
      maxP = Math.max(max, maxP);
    }

    return maxP;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] a = { 5, -4, 3, -2 };
    System.out.println(maxprod(a));
    sc.close();
  }
}