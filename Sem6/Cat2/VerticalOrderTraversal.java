import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    public char[] data;

    TreeNode(int val) {
        this.val = val;
    }
}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.putIfAbsent(p.col, new ArrayList<>());
            map.get(p.col).add(p.node.val);

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.col - 1));
            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.col + 1));
        }

        return new ArrayList<>(map.values());
    }

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }

    // Helper method to create a binary tree from an array
    public static TreeNode createTreeFromArray(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null || arr[index] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index]);
        root.left = createTreeFromArray(arr, 2 * index + 1);
        root.right = createTreeFromArray(arr, 2 * index + 2);

        return root;
    }

    // Main method to test
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4, null, 6, 7 };

        TreeNode root = createTreeFromArray(arr, 0);

        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        System.out.println("Vertical Order: " + tree.verticalOrder(root));
    }
}