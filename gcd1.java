import java.util.Scanner;

public class gcd1 {
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = gcd(a, b);
        System.out.println(result);
        sc.close();
    }
}