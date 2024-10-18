import java.util.Scanner;

class binaryP {
    public static boolean binary_p(int x) {
        int reverse = 0;
        int original = x;
        while (x > 0) {
            reverse = reverse << 1;
            reverse = reverse | (x & 1);
            x = x >> 1;
        }

        return reverse == original;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (binary_p(a)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        sc.close();
    }
}