import java.util.*;

class BinomialHeap {
    private List<int[]> heap; // Each binomial tree is stored as an array

    public BinomialHeap() {
        heap = new ArrayList<>();
    }

    // Insert an element by adding a single-node tree
    public void insert(int key) {
        List<int[]> tempHeap = new ArrayList<>();
        tempHeap.add(new int[] { key }); // Single-node binomial tree
        merge(tempHeap);
    }

    // Merge two binomial heaps
    private void merge(List<int[]> otherHeap) {
        heap.addAll(otherHeap);
        consolidate();
    }

    // Consolidate trees of the same degree
    private void consolidate() {
        heap.sort(Comparator.comparingInt(arr -> arr.length)); // Sort trees by size
        List<int[]> newHeap = new ArrayList<>();
        for (int[] tree : heap) {
            if (!newHeap.isEmpty() && newHeap.get(newHeap.size() - 1).length == tree.length) {
                tree = mergeTrees(newHeap.remove(newHeap.size() - 1), tree);
            }
            newHeap.add(tree);
        }
        heap = newHeap;
    }

    // Merge two binomial trees
    private int[] mergeTrees(int[] t1, int[] t2) {
        if (t1[0] > t2[0])
            return mergeTrees(t2, t1);
        int[] merged = new int[t1.length + 1];
        merged[0] = t1[0];
        System.arraycopy(t1, 1, merged, 1, t1.length - 1);
        System.arraycopy(t2, 0, merged, t1.length, t2.length);
        return merged;
    }

    // Get the minimum value
    public int getMin() {
        return heap.stream().min(Comparator.comparingInt(t -> t[0])).orElse(new int[] { -1 })[0];
    }

    // Extract and remove the minimum element
    public int extractMin() {
        if (heap.isEmpty())
            return -1;
        int[] minTree = heap.stream().min(Comparator.comparingInt(t -> t[0])).orElse(null);
        heap.remove(minTree);
        List<int[]> tempHeap = new ArrayList<>();
        for (int i = 1; i < minTree.length; i++) {
            tempHeap.add(new int[] { minTree[i] });
        }
        merge(tempHeap);
        return minTree[0];
    }

    // Display heap
    public void displayHeap() {
        System.out.println("Binomial Heap:");
        for (int[] tree : heap) {
            System.out.println(Arrays.toString(tree));
        }
    }

    public static void main(String[] args) {
        BinomialHeap binHeap = new BinomialHeap();
        binHeap.insert(12);
        binHeap.insert(8);
        binHeap.insert(5);
        binHeap.insert(15);
        binHeap.insert(7);
        binHeap.insert(2);
        binHeap.insert(9);

        binHeap.displayHeap();
        System.out.println("Min: " + binHeap.getMin());
        binHeap.extractMin();
        binHeap.displayHeap();
    }
}