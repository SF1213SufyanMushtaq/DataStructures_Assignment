import java.util.Scanner;

public class ArrayInsertion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] arr = {10, 20, 30, 40, 50};

        System.out.print("Enter the index K (0 to " + (arr.length - 1) + "): ");
        int index = scanner.nextInt();

        System.out.print("Enter a positive integer ITEM: ");
        int ITEM = scanner.nextInt();

        insert(arr, index, ITEM);

        // Print the updated array
        System.out.print("Updated array: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }

        scanner.close();
    }

    public static void insert(int[] LA, int K, int ITEM) {

        if (K < 0 || K >= LA.length) {
            System.out.println("Error: Index K is out of range.");
            return;
        }

        // b) Check if ITEM is a positive integer
        if (ITEM <= 0) {
            System.out.println("Error: ITEM must be a positive integer.");
            return;
        }


        if (ITEM < LA[K]) {

            LA[K] = ITEM;
            System.out.println("ITEM inserted at index " + K + ": " + ITEM);
        } else {
            System.out.println(LA[K] + " at index " + K + " is greater than or equal to user's entered ITEM " + ITEM);
        }
    }
}