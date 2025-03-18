import java.util.Collections;
import java.util.List;

public class kAryHeap {
    public static List<Integer> heap;
    public static int k;

    kAryHeap(int ks) {
        k = ks;
    }

    public static void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size() - 1);
    }

    public static void heapifyUp(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && heap.get(i) < heap.get(parent)) {
            Collections.swap(heap, i, parent);
            i = parent;
            parent = (i - 1) / k;
        }
    }

    public int extractMin() {
        if (heap.isEmpty())
            return -1;
        int min = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return min;
    }

    public void heapifyDown(int i) {
        int minIndex = i;
        for (int j = 1; j <= k; j++) {
            int child = k * i * j;
            if (child < heap.size() && heap.get(child) < heap.get(minIndex)) {
                minIndex = child;
            }
        }

        if (minIndex != i) {
            Collections.swap(heap, i, minIndex);
            heapifyDown(minIndex);
        }
    }

    public static void main(String[] args) {
       
    }
}
