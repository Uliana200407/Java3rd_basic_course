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
        int rows = matrix.length;
        int cols = matrix[0].length;
        byte[][] transposedMatrix = new byte[cols][rows];  // Invert rows and cols

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];  // Swap rows and columns
            }
        }
        return transposedMatrix;
    }

    /**
     * Calculates the sum of the lowest elements in each row of the matrix.
     *
     * @param matrix the matrix to process
     * @return the sum of the minimum elements of each row
     */
    public static int calculateMinRowSum(byte[][] matrix) {
        int sum = 0;
        for (byte[] row : matrix) {
            byte minInRow = row[0]; // Assume the first element is the smallest initially
            for (byte num : row) {
                if (num < minInRow) {
                    minInRow = num; // Update min if a smaller value is found
                }
            }
            sum += minInRow; // Add the smallest value of this row to the sum
        }
        return sum;
    }

    /**
     * Prints the matrix to the console.
     *
     * @param matrix the matrix to print
     */
    public static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
