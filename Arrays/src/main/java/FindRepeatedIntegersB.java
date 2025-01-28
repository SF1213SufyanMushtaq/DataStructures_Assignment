import java.util.HashMap;
import java.util.Scanner;

public class FindRepeatedIntegersB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array (n ≥ 6): ");
        int n = scanner.nextInt();

        int[] B = new int[n];
        System.out.println("Enter " + n + " integers (from 1 to " + (n - 5) + "):");
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        findRepeated(B);
    }

    public static void findRepeated(int[] B) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : B) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        System.out.println("The repeated integers are:");
        int foundCount = 0;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > 1) {
                System.out.print(key + " ");
                foundCount++;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        if (foundCount == 0) {
            System.out.println("No repeated integers found.");
        } else if (foundCount < 5) {
            System.out.println("\nFewer than 5 repeated integers found.");
        }
    }
}
