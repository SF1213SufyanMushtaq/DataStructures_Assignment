package estate.pk;

public class MatrixMultiplication {
    public static void main(String[] args) {
        // Example matrices A and B (both n x n)
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

        // Perform matrix multiplication
        int[][] C = multiplyMatrices(A, B);

        // Output the result matrix C
        if (C != null) {
            System.out.println("Matrix C (A * B):");
            printMatrix(C);
        } else {
            System.out.println("Matrix dimensions are not compatible for multiplication.");
        }
    }

    // Function to multiply two matrices A and B
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        // Check if multiplication is possible (columns of A == rows of B)
        if (A[0].length != B.length) {
            return null;  // Return null if the dimensions are not compatible
        }

        int n = A.length;  // Number of rows in A (also the number of rows in C)
        int m = B[0].length; // Number of columns in B (also the number of columns in C)
        int[][] C = new int[n][m];  // Resultant matrix C

        // Perform matrix multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = 0;  // Initialize the element at position C[i][j]
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];  // Sum the product of corresponding elements
                }
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
            System.out.println();  // Move to next line after each row
        }
    }
}