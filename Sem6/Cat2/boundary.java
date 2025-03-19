class TreeNode {
    int data;
    TreeNode right, left;

    TreeNode(int data) {
        this.data = data;
        right = left = null;
    }
}

public class boundary {
    public static void printLeftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        System.out.println(root.data);
        if (root.left != null) {
            printLeftBoundary(root.left);
        } else {
            printLeftBoundary(root.right);
        }
    }

    public static void printRightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (root.right != null) {
            printRightBoundary(root.right);
        } else {
            printRightBoundary(root.left);
        }
        System.out.println(root.data);
    }

    public static void printLeaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.println(root.data);
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);

    }

    public static void boundaryTravers(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);

    }

    public static TreeNode createTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = createTree(arr, 2 * index + 1);
        root.right = createTree(arr, 2 * index + 2);
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 1, 2, 3, 4, null, 6, 7 };

        TreeNode root = createTree(arr, 0);
        boundaryTravers(root);
    }
}