import java.util.Scanner;

public class swapNibbles {
  public static int swapNibbles1(int x) {
    return ((x & 0x0F) << 4 | (x & 0xF0) >> 4);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    byte a = sc.nextByte();
    System.out.println(swapNibbles1(a));
    sc.close();
  }
}