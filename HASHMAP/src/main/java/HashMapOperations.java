// Different hashmap problems
import java.util.*;

class HashMapOperations {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // 1. Insertion
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");
        map.put(4, "Date");

        System.out.println("Original HashMap: " + map);

        // 2. Searching for a key
        int searchKey = 3;
        if (map.containsKey(searchKey)) {
            System.out.println("Key " + searchKey + " found with value: " + map.get(searchKey));
        } else {
            System.out.println("Key " + searchKey + " not found.");
        }

        // 3. Deletion
        map.remove(2); // Removing key 2
        System.out.println("After removing key 2: " + map);

        // 4. Updating a value
        map.put(3, "Coconut"); // Updating key 3
        System.out.println("After updating key 3: " + map);

        // 5. Iterating through HashMap
        System.out.println("Iterating through HashMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 6. Finding the most frequent element
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        System.out.println("Most Frequent Element: " + findMostFrequent(arr));

        // 7. Sorting HashMap by keys
        TreeMap<Integer, String> sortedMap = new TreeMap<>(map);
        System.out.println("Sorted HashMap by keys: " + sortedMap);
    }

    // Function to find the most frequent element in an array
    public static int findMostFrequent(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0, mostFrequent = -1;

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if (freqMap.get(num) > maxFreq) {
                maxFreq = freqMap.get(num);
                mostFrequent = num;
            }
        }
        return mostFrequent;
    }
}

