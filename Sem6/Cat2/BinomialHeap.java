import java.util.*;

public class BinomialHeap{
    static class Node{
        int key;
        List<Node> children = new ArrayList<>();
        Node(int key){
            this.key = key;
        }
    }
    private List<Node>heap = new ArrayList<>();

    public void insert(int key){
        BinomialHeap tempHeap = new BinomialHeap();
        tempHeap.heap.add(new Node(key));
        union(tempHeap);
    }

    public void union(BinomialHeap other){
        heap.addAll(other.heap);
        heap.sort(Comparator.comparingInt(n->n.children.size()));

        for (int i = 0; i < heap.size() - 1; i++) {
            Node x = heap.get(i);
            Node y = heap.get(i + 1);

            if (x.children.size() == y.children.size()) {
                if (x.key <= y.key) {
                    x.children.add(y);
                    heap.remove(i + 1);
                } else {
                    y.children.add(x);
                    heap.remove(i);
                }
                i--;
            }
        }
    }
    
    public static void main(String[] args) {
        BinomialHeap heap = new BinomialHeap();

    }
}