public class eulers_pi {
    public static int phi(int n) {
        int result = n;
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n = n / p;
                }
                result = result - result / p;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(phi(n));
    }
}
