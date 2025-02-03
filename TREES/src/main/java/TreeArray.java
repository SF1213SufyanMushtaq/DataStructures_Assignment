import java.util.Arrays;

class TreeArray {
    private int[] tree;
    private int size;

    public TreeArray(int capacity) {
        tree = new int[capacity];
        Arrays.fill(tree, -1); // Using -1 to indicate empty nodes
        size = capacity;
    }

    public void setRoot(int value) {
        tree[0] = value;
    }

    public void setLeftChild(int parentIndex, int value) {
        int leftChildIndex = 2 * parentIndex + 1;
        if (leftChildIndex < size) {
            tree[leftChildIndex] = value;
        }
    }

    public void setRightChild(int parentIndex, int value) {
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex < size) {
            tree[rightChildIndex] = value;
        }
    }

    public void printTree() {
        System.out.println(Arrays.toString(tree));
    }

    public static void main(String[] args) {
        TreeArray tree = new TreeArray(10);
        tree.setRoot(1);
        tree.setLeftChild(0, 2);
        tree.setRightChild(0, 3);
        tree.setLeftChild(1, 4);
        tree.setRightChild(1, 5);
        tree.setLeftChild(2, 6);
        tree.setRightChild(2, 7);

        tree.printTree(); // Output: [1, 2, 3, 4, 5, 6, 7, -1, -1, -1]
    }
}
