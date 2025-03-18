import java.util.*;

public class stockSpan {
    public static void calculate(int[] arr, int n, int[] S) {
        Stack<Integer> s = new Stack<>();
        S[0] = 1;
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            S[i] = s.isEmpty() ? (i + 1) : (i - s.peek());
            s.push(i);
        }
    }

    public static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int S[] = new int[n];
        calculate(arr, n, S);
        printArray(S);
        sc.close();
    }
}
