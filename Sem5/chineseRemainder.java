import java.util.*;

public class chineseRemainder {
    public static int remTheorem(int size, int div[], int rem[]) {
        int x = 1;
        int i;
        while (true) {
            for (i = 0; i < size; i++) {
                if (x % div[i] != rem[i])
                    break;

            }
            if (i == size) {
                return x;
            }
            x++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No. of Divisor");
        int size = sc.nextInt();
        int[] div = new int[size];
        for (int i = 0; i < size; i++) {
            div[i] = sc.nextInt();
        }
        int[] rem = new int[size];
        for (int i = 0; i < size; i++) {
            rem[i] = sc.nextInt();
        }
        System.out.println(remTheorem(size, div, rem));
        sc.close();
    }
}
