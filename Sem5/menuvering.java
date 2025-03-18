public class menuvering {
    public static int numberOfPath(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return numberOfPath(m - 1, n) + numberOfPath(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(numberOfPath(3, 3));
    }
}
