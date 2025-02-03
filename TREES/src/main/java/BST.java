// Simple Binary Search Tree (BST) with Delete Method
class BST {


    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BST() {
        root = null;
    }

    // Insert a node
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Delete a node
    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null) return root;

        // Find the node to delete
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Case 1: Node has no child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node has one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Node has two children
            root.key = minValue(root.right); // Get inorder successor
            root.right = deleteRec(root.right, root.key); // Delete the successor
        }
        return root;
    }

    int minValue(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    // Inorder traversal (Left → Root → Right)
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test deletion cases
    public static void main(String[] args) {
        BST tree = new BST();

        // Insert nodes
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            tree.insert(val);
        }

        System.out.println("Original Inorder Traversal:");
        tree.inorder();  // Expected: 20 30 40 50 60 70 80

        // Test: Delete a leaf node (20)
        tree.delete(20);
        System.out.println("After deleting leaf node 20:");
        tree.inorder();  // Expected: 30 40 50 60 70 80

        // Test: Delete a node with one child (30)
        tree.delete(30);
        System.out.println("After deleting node 30 (one child):");
        tree.inorder();  // Expected: 40 50 60 70 80

        // Test: Delete a node with two children (50)
        tree.delete(50);
        System.out.println("After deleting node 50 (two children):");
        tree.inorder();  // Expected: 40 60 70 80
    }
}
