import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] LA = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        System.out.print("Enter the item to search: ");
        int ITEM = scanner.nextInt();

        search(LA, ITEM);
    }

    public static void search(int[] LA, int ITEM) {
        int index = -1;

        // Search for the item in the array
        for (int i = 0; i < LA.length; i++) {
            if (LA[i] == ITEM) {
                index = i;
                break;
            }
        }

        // If the item is found
        if (index != -1) {
            System.out.println("Item " + ITEM + " found at index " + index + ".");

            if (index + 1 < LA.length) {
                System.out.print("Right neighbors: ");
                System.out.print(LA[index + 1]);
                if (index + 2 < LA.length) {
                    System.out.print(", " + LA[index + 2]);
                } else {
                    System.out.print(" (no second right neighbor)");
                }
                System.out.println();
            } else {
                System.out.println("No right neighbor.");
            }


            if (index - 1 >= 0) {
                System.out.print("Left neighbors: ");
                System.out.print(LA[index - 1]);
                if (index - 2 >= 0) {
                    System.out.print(", " + LA[index - 2]);
                } else {
                    System.out.print(" (no second left neighbor)");
                }
                System.out.println();
            } else {
                System.out.println("No left neighbor.");
            }
        } else {
            System.out.println("Item " + ITEM + " does not exist in the array.");
        }
    }
}
