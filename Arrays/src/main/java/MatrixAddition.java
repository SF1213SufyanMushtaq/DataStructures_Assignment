package estate.pk;

public class MatrixAddition {
    public static void main(String[] args) {
        // Example matrices A and B
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] B = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        // Perform matrix addition
        int[][] C = addMatrices(A, B);

        // Output the result matrix C
        if (C != null) {
            System.out.println("Matrix C (A + B):");
            printMatrix(C);  // Correctly call printMatrix
        } else {
            System.out.println("Matrix dimensions are not compatible for addition.");
        }
    }

    // Function to add two matrices A and B
    public static int[][] addMatrices(int[][] A, int[][] B) {
        // Check if dimensions of A and B are the same
        if (A.length != B.length || A[0].length != B[0].length) {
            return null;  // Return null if dimensions do not match
        }

        int n = A.length; // Number of rows
        int m = A[0].length; // Number of columns
        int[][] C = new int[n][m]; // Resultant matrix C

        // Perform element-wise addition
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C; // Return the result matrix
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to next line after each row
        }
    }
}