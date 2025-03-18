import java.util.Scanner;

public class longestSub1 {
  public static int longestSubseq1(String a) {
    int maxLength = 0;
    int currentLength = 0;
    int previousLength = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == '1') {
        currentLength++;
      } else {
        maxLength = Math.max(maxLength, currentLength + previousLength + 1);
        previousLength = currentLength;
        currentLength = 0;

      }
      maxLength = Math.max(maxLength, currentLength + previousLength + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.nextLine();
    System.out.println(longestSubseq1(a));
    sc.close();
  }
}