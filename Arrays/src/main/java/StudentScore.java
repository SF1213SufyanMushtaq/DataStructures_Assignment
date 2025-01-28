// This question is to manage a list of students' scores for a small school by inserting searching and
// 3.	Transpose a 2D Matrix of Scores
package org.example;

import java.util.Scanner;

public class StudentScore {
    private int[] scores;
    private int[][] scoreMatrix;

    public StudentScore(int size) {
        scores = new int[size];
    }

    public void insertScore(int index, int newScore) {
        if (index < 0 || index >= scores.length) {
            System.out.println("Index out of bounds.");
            return;
        }
        if (newScore <= 0) {
            System.out.println("Score must be a positive integer.");
            return;
        }
        if (newScore < scores[index] || scores[index] == 0) {
            scores[index] = newScore;
            System.out.println("Score inserted at index " + index);
        } else {
            System.out.println("Entered score is greater than the existing score at index " + index);
        }
    }


    public void searchScore(int scoreToFind) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == scoreToFind) {
                System.out.println("Score found at index " + i);
                if (i > 0) {
                    System.out.println("Left neighbor: " + scores[i - 1]);
                } else {
                    System.out.println("No left neighbor.");
                }
                if (i < scores.length - 1) {
                    System.out.println("Right neighbor: " + scores[i + 1]);
                } else {
                    System.out.println("No right neighbor.");
                }
                return;
            }
        }
        System.out.println("Score not found.");
    }


    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
    public void printScores() {
        System.out.print("Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentScore studentScores = new StudentScore(5);


        studentScores.insertScore(0, 85);
        studentScores.insertScore(1, 90);
        studentScores.insertScore(2, 75);
        studentScores.insertScore(3, 80);
        studentScores.insertScore(4, 95);


        studentScores.printScores();


        System.out.print("Enter a score to search: ");
        int scoreToSearch = scanner.nextInt();
        studentScores.searchScore(scoreToSearch);


        int[][] scoreMatrix = {
                {85, 90, 75},
                {80, 95, 88},
                {70, 60, 65}
        };

        System.out.println("Original Matrix:");
        printMatrix(scoreMatrix);

        int[][] transposedMatrix = studentScores.transposeMatrix(scoreMatrix);
        System.out.println("Transposed Matrix:");
        printMatrix(transposedMatrix);

        scanner.close();
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int score : row) {
                System.out.print(score + " ");
            }
            System.out.println();
        }
    }
}