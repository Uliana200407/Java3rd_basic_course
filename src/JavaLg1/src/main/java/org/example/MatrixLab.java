package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixLab {

    public static void main(String[] args) {
        // Define matrix dimensions
        final int rows = 3;
        final int cols = 3;

        // Initialize matrix
        byte[][] matrix = new byte[rows][cols];

        // Initialize scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the elements of the matrix (" + rows + "x" + cols + "):");

        // Loop through matrix and get user input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("matrix[" + i + "][" + j + "]: ");
                        matrix[i][j] = scanner.nextByte();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: you've entered an incorrect value. Please enter a byte value.");
                        scanner.next(); // Clear the buffer
                    }
                }
            }
        }

        // Print the initial matrix
        System.out.println("Initial matrix:");
        printMatrix(matrix);

        // Transpose the matrix and print the result
        byte[][] transposedMatrix = transposeMatrix(matrix);
        System.out.println("Transposed matrix:");
        printMatrix(transposedMatrix);

        // Calculate and print the minimum row sum
        int minSum = calculateMinRowSum(matrix);
        System.out.println("The sum of the lowest elements of every row: " + minSum);

        // Close scanner
        scanner.close();
    }

    /**
     * Transposes the given matrix.
     *
     * @param matrix the matrix to transpose
     * @return the transposed matrix
     */
    public static byte[][] transposeMatrix(byte[][] matrix) {
        // Get matrix dimensions
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Create a new matrix for the transposed result
        byte[][] transposedMatrix = new byte[cols][rows];

        // Fill the transposed matrix with values from the original matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    /**
     * Calculates the minimum row sum from the matrix.
     *
     * @param matrix the matrix to calculate the row sums from
     * @return the minimum row sum
     */
    public static int calculateMinRowSum(byte[][] matrix) {
        // Initialize minSum to the maximum possible integer value
        int minSum = Integer.MAX_VALUE;

        // Iterate through each row
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;

            // Sum elements in the row
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }

            // Update minSum if the current row sum is smaller
            if (rowSum < minSum) {
                minSum = rowSum;
            }
        }

        return minSum;
    }

    /**
     * Prints the given matrix to the console.
     *
     * @param matrix the matrix to print
     */
    public static void printMatrix(byte[][] matrix) {
        // Loop through rows and columns to print the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t"); // Tab-separated values
            }
            System.out.println(); // Newline after each row
        }
    }
}
