
public class oddEven {

    public static void main(String[] args) {
        int[] a = { 5, 6, 3, 5, 4, 8 };
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                System.out.print(a[i] + " ");
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
