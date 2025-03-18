import java.util.Scanner;

public class booth {
  public static int boothAlgorithm(int n1, int n2) {
    int r = n2;
    int A = n1;
    int P = 0;
    int count = Integer.SIZE;
    while (count > 0) {
      if ((r & 1) == 1) {
        P = P + A;

      }
      A <<= 1;
      count--;
      r >>= 1;
    }
    return P;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int result = boothAlgorithm(a, b);
    System.out.println(result);
    sc.close();
  }
}
