import java.util.*;

public class Strobo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // String n = sc.nextLine();
        String n = "16806590891";
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int l = 0, r = n.length() - 1;
        Boolean k = false;
        while (l < r) {
            if (!map.containsKey(n.charAt(l))) {
                System.out.println("NO");
                k = true;
                break;
            }
            if (map.get(n.charAt(l)) != n.charAt(r)) {
                System.out.println("NO");
                k = true;
                break;
            }
            l++;
            r--;
        }
        if (!k)
            System.out.println("YES");
        sc.close();
    }
}