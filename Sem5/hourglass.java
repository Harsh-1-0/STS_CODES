import java.util.Scanner;

public class hourglass {
    public static int findMax(int[][] mat, int R, int C) {
        int max_sum = 0;
        int sum = 0;
        if (R < 3 || C < 3) {
            System.exit(0);
        }
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {
                sum = (mat[i][j] + mat[i][j + 1] +
                        mat[i][j + 2]) + (mat[i + 1][j + 1]) +
                        (mat[i + 2][j] + mat[i + 2][j + 1] +
                                mat[i + 2][j + 2]);
                max_sum = Math.max(max_sum, sum);

            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.close();
    }
}