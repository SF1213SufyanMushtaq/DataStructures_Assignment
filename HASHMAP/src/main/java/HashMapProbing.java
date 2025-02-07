import java.util.Arrays;

class HashMapProbing {
    private int size;        // Hash table size
    private int[] table;     // Hash table
    private boolean[] used;  // Marks used slots

    // Constructor
    public HashMapProbing(int size) {
        this.size = size;
        table = new int[size];
        used = new boolean[size];
        Arrays.fill(table, -1); // -1 indicates empty slot
    }

    // Hash function
    private int hash(int key) {
        return key % size;
    }

    // Insert function with linear probing
    public void insert(int key) {
        int index = hash(key);
        int startIndex = index; // Track starting index to avoid infinite loops

        while (used[index]) { // If occupied, probe next slot
            index = (index + 1) % size;
            if (index == startIndex) { // Table is full
                System.out.println("Hash Table is Full!");
                return;
            }
        }

        table[index] = key;
        used[index] = true;
    }

    // Search function
    public boolean search(int key) {
        int index = hash(key);
        int startIndex = index;

        while (used[index]) {
            if (table[index] == key) return true;
            index = (index + 1) % size;
            if (index == startIndex) return false; // If back to start, key not found
        }
        return false;
    }

    // Delete function
    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;

        while (used[index]) {
            if (table[index] == key) {
                table[index] = -1;  // Mark as deleted
                return;
            }
            index = (index + 1) % size;
            if (index == startIndex) return; // Key not found
        }
    }

    // Display the hash table
    public void display() {
        System.out.println("Hash Table: " + Arrays.toString(table));
    }

    public static void main(String[] args) {
        HashMapProbing hashTable = new HashMapProbing(7);

        hashTable.insert(10);
        hashTable.insert(20);
        hashTable.insert(30);
        hashTable.insert(17); // Causes collision, gets probed
        hashTable.insert(27); // Another collision

        hashTable.display();

        System.out.println("Search 20: " + hashTable.search(20));
        System.out.println("Search 50: " + hashTable.search(50));

        hashTable.delete(20);
        hashTable.display();
    }
}
