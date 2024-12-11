public class toggle {
    public static void main(String[] args) {
        int n = 100;
        boolean[] door = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j * i <= n; j++) {
                if (door[j]) {
                    door[j] = false;
                } else {
                    door[j] = true;
                }
            }
        }
        int c = 0, o = 0;
        for (int i = 1; i < n; i++) {
            if (door[i]) {
                c++;
            } else {
                o++;
            }
        }
        System.out.println(o + " " + c);

    }
}
