import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class test {
    public static void binaryP(int n) {
        int ori = n;
        int newP = 0;
        while (n > 0) {
            newP = newP * 2;
            newP = newP + (n & 1);
            n = n / 2;
        }
        System.out.println(newP == ori);
    }

    public static int Booth(int n1, int n2) {
        int r = n1;
        int A = n2;
        int P = 0;
        int count = Integer.SIZE;
        while (count > 0) {
            if ((r & 1) == 1) {
                P += A;
            }
            count--;
            A = A * 2;
            r = r / 2;
        }
        return P;
    }

    public static int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return GCD(b % a, a);
    }

    public static long karatsuba(long x, long y) {
        if (x < 10 || y < 10) {
            return x * y;
        }
        int n = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int half = (n + 1) / 2;

        long a = x / (long) Math.pow(10, half);
        long b = x % (long) Math.pow(10, half);
        long c = y / (long) Math.pow(10, half);
        long d = y % (long) Math.pow(10, half);

        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long ad_bc = karatsuba(a + b, c + d) - ac - bd;

        return (long) (ac * Math.pow(10, half * 2) + ad_bc * Math.pow(10, half) + bd);
    }

    public static void swapNibble(byte n) {
        byte upper = (byte) ((n & 0xF0) >> 4);
        byte lower = (byte) ((n & 0x0F));

        byte swapped = (byte) ((lower << 4) | upper);
        System.out.println(swapped);
    }

    public static void blockSwap(int[] arr, int r) {
        int n = arr.length;
        r = r % n;
        if (r == 0) {
            return;
        }
        swap(arr, 0, r - 1);
        swap(arr, r, n - 1);
        swap(arr, 0, n - 1);
    }

    public static void swap(int[] arr, int a, int b) {
        while (a < b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }

    public static int maxProd(int[] a) {
        int max = a[0], m = a[0], min = a[0], temp = 0;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[0] > 0) {
                max = Math.max(a[i], max * a[i]);
                min = Math.min(a[i], min * a[i]);
            } else if (a[0] == 0) {
                max = min = 0;
            } else {
                temp = max;
                max = Math.max(a[i], min * a[i]);
                min = Math.min(a[i], temp * a[i]);
            }
            m = Math.max(m, max);
        }
        return m;
    }

    public static int maxEqui(int[] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        int leftSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = a.length - 1; i > 0; i--) {
            total = total - a[i];
            if (leftSum == total && leftSum > maxSum) {
                maxSum = leftSum;
            }
            leftSum += a[i];
        }
        return maxSum;

    }

    public static void findLeaders(int[] lead) {
        int n = lead.length;
        Stack<Integer> res = new Stack<>();
        res.push(lead[n - 1]);

        for (int i = n - 2; i > 0; i--) {
            if (lead[i] > lead[i + 1]) {
                res.push(lead[i]);
            }
        }
        while (!res.empty()) {
            System.out.print(res.peek() + " ");
            res.pop();
        }
    }

    public static void findMaj(int[] n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : n) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) > n.length / 2) {
                System.out.println(i);
                return;
            }
        }
    }

    public static int longestCosecutive(int n) {
        String binary = Integer.toBinaryString(n);
        int maxLength = 0;
        int currLength = 0;
        int prevLength = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                currLength++;
            } else {
                maxLength = Math.max(maxLength, currLength + prevLength + 1);
                prevLength = currLength;
                currLength = 0;
            }
        }
        maxLength = Math.max(maxLength, currLength + prevLength + 1);
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // binaryP(16);

        // int n = Booth(10, 20);

        // System.out.println(GCD(22, 14));

        // System.out.println(karatsuba(100, 20000));

        // int k = 10;
        // byte a = (byte) k;
        // swapNibble(a);

        // System.out.println("Enter size of array");
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }
        // System.out.println("Enter rotate pivot");
        // int rotate = sc.nextInt();
        // blockSwap(arr, rotate);

        // for (int a : arr) {
        // System.out.print(a + " ");
        // }
        // System.out.println();

        // int[] a = { 1, 2, 3, 4, 5 };
        // System.out.println(maxProd(a));

        // int[] arr = { 1, 2, 3, 4, 5, 4, 3, 2, 1 };
        // System.out.println(maxEqui(arr));

        // int[] lead = { 16, 17, 4, 3, 5, 2 };
        // findLeaders(lead);

        // int[] maj = { 2, 6, 2, 2, 6, 2, 2, 8, 2, 1 };
        // findMaj(maj);

        int num = 13;
        System.out.println(longestCosecutive(num));
        sc.close();
    }
}
