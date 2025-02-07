import java.util.LinkedList;

class HashMapChaining {
    private int size;
    private LinkedList<Integer>[] table;

    // Constructor
    public HashMapChaining(int size) {
        this.size = size;
        table = new LinkedList[size];

        // Initialize linked lists for chaining
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hash(int key) {
        return key % size;
    }

    // Insert function
    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
    }

    // Search function
    public boolean search(int key) {
        int index = hash(key);
        return table[index].contains(key);  // Checks if key exists in the linked list
    }

    // Delete function
    public void delete(int key) {
        int index = hash(key);
        table[index].remove((Integer) key);  // Remove the key from the linked list
    }

    // Display the HashMap
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }

    public static void main(String[] args) {
        HashMapChaining hashTable = new HashMapChaining(7);

        // Insert elements
        hashTable.insert(10);
        hashTable.insert(20);
        hashTable.insert(30);
        hashTable.insert(17); // Collides with 10 (same index)
        hashTable.insert(27); // Collides with 20 (same index)

        hashTable.display();

        // Search elements
        System.out.println("Search 20: " + hashTable.search(20));  // true
        System.out.println("Search 50: " + hashTable.search(50));  // false

        // Delete element
        hashTable.delete(20);
        hashTable.display();
    }
}

