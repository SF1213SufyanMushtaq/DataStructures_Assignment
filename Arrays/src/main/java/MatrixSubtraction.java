package estate.pk;

public class MatrixSubtraction {
    public static void main(String[] args) {
        // Example matrices A and B
        int[][] A = {
                {5, 7, 9},
                {4, 2, 6},
                {8, 1, 3}
        };

        int[][] B = {
                {2, 3, 1},
                {1, 2, 3},
                {4, 5, 6}
        };

        // Perform matrix subtraction
        int[][] C = subtractMatrices(A, B);

        // Output the result matrix C
        if (C != null) {
            System.out.println("Matrix C (A - B):");
            printMatrix(C);
        } else {
            System.out.println("Matrix dimensions are not compatible for subtraction.");
        }
    }

    // Function to subtract two matrices A and B
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        // Check if dimensions of A and B are the same
        if (A.length != B.length || A[0].length != B[0].length) {
            return null;  // Return null if dimensions do not match
        }

        int n = A.length; // Number of rows
        int m = A[0].length; // Number of columns
        int[][] C = new int[n][m]; // Resultant matrix C

        // Perform element-wise subtraction
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                C[i][j] = A[i][j] - B[i][j];
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
            System.out.println(); // Move to the next line after each row
        }
    }
}