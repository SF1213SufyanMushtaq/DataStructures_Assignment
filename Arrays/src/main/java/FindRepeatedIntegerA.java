import java.util.HashSet;
import java.util.Scanner;

public class FindRepeatedIntegerA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array (n ≥ 2): ");
        int n = scanner.nextInt();

        int[] A = new int[n];
        System.out.println("Enter " + n + " integers (from 1 to " + (n - 1) + "):");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int repeated = findRepeated(A);
        if (repeated != -1) {
            System.out.println("The repeated integer is: " + repeated);
        } else {
            System.out.println("No repeated integer found.");
        }
    }

    public static int findRepeated(int[] A) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : A) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }
}