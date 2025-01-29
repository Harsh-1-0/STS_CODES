import java.util.*;

public class celebrity {
    public static int Celibrity(int mat[][]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < mat.length; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int row = st.pop();
            int col = st.pop();

            if (mat[row][col] == 1) {
                st.push(col);
            } else {
                st.push(row);
            }
        }
        int x = st.pop();
        for (int j = 0; j < mat.length; j++) {
            if (j == x)
                continue;
            if (mat[x][j] == 1) {
                return -1;
            }
        }
        for (int i = 0; i < mat.length; i++) {
            if (i == x)
                continue;
            if (mat[i][x] == 0) {
                return -1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int result = Celibrity(matrix);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else {
            System.out.println("Celebrity is: " + result);
        }
        sc.close();
    }
}
