import java.util.Set;
import java.util.HashSet;

public class permutation {
    public static void permute(String n, int index, Set<String> s) {
        if (index >= n.length()) {
            s.add(n);
            return;
        }
        for (int i = index; i < n.length(); i++) {
            n = swap(n, index, i);
            permute(n, index + 1, s);
            n = swap(n, index, i);
        }
    }

    public static String swap(String n, int i, int j) {
        char[] arr = n.toCharArray();
        char temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return new String(arr);
    }

    public static void main(String[] args) {
        String n = "AAC";
        Set<String> s = new HashSet<String>();
        permute(n, 0, s);
        for (String item : s) {
            System.out.println(item);
        }
    }
}
