// Simple Recursive Method to Find Height of a Node in BST
class BinaryTreeHeightFinder {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinaryTreeHeightFinder() {
        root = null;
    }

    // Insert a node into BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insertRec(root.left, key);
        else root.right = insertRec(root.right, key);
        return root;
    }

    // Recursive method to find the height of a node
    int findHeight(Node node) {
        if (node == null) return -1; // Base case: If node is null, height is -1
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }

    // Find the height of a node with given key
    int getHeight(int key) {
        Node node = search(root, key);
        if (node == null) return -1; // If node not found, return -1
        return findHeight(node);
    }

    // Search for a node
    Node search(Node root, int key) {
        if (root == null || root.key == key) return root;
        return key < root.key ? search(root.left, key) : search(root.right, key);
    }

    // Main method to test
    public static void main(String[] args) {
        BinaryTreeHeightFinder tree = new BinaryTreeHeightFinder();

        // Insert nodes
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) tree.insert(val);

        // Find height of nodes
        System.out.println("Height of node 50: " + tree.getHeight(50)); // Expected: 2
        System.out.println("Height of node 30: " + tree.getHeight(30)); // Expected: 1
        System.out.println("Height of node 70: " + tree.getHeight(70)); // Expected: 1
        System.out.println("Height of node 20: " + tree.getHeight(20)); // Expected: 0
        System.out.println("Height of node 100: " + tree.getHeight(100)); // Expected: -1 (Not found)
    }
}

