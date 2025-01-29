import java.util.*;

public class priority {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 2, -9, 44, 22 };
        int priorityArr[] = { 5, 2, 3, 1, 4, 0, 6 }; // Lower index -> Higher priority

        // Create a map to store priorities for each number
        Map<Integer, Integer> priorityMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            priorityMap.put(arr[i], priorityArr[i]);
        }

        // Custom comparator using priority array
        PriorityQueue<Integer> pq = new PriorityQueue<>((b, a) -> {
            return Integer.compare(priorityMap.get(a), priorityMap.get(b));
        });

        // Add elements
        for (int num : arr) {
            pq.add(num);
        }

        // Print in custom priority order
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
