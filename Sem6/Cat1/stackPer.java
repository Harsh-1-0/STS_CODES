import java.util.*;

public class stackPer {
    public static Boolean check(int ip[], int op[], int n) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        for (int ele : ip) {
            s.push(ele);
            while (!s.isEmpty() && s.peek() == op[i]) {
                s.pop();
                i++;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[] = new int[n];
        int output[] = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            output[i] = sc.nextInt();
        if (check(input, output, n))
            System.out.println("Yes");
        else
            System.out.println("Not Possible");
        sc.close();
    }
}