import java.util.HashMap;

public class MajorityElement {
    public static int majority(int[] ans) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : ans) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int majority = ans.length / 2;
        for (int key : map.keySet()) {
            if (map.get(key) > majority) {
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 2, 3, 4, 1, 1, 1, 1 };
        System.out.println(majority(arr));
    }
}