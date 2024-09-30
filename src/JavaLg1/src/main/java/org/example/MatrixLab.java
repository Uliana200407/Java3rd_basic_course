package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MatrixLab {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;

        byte[][] matrix = new byte[rows][cols];

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the elements of the matrix (" + rows + "x" + cols + "):");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        System.out.print("matrix[" + i + "][" + j + "]: ");
                        matrix[i][j] = scanner.nextByte();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: you've entered incorrect values. Please, renter the specific type of the value - byte.");
                        scanner.next();
                    }
                }
            }
        }

        System.out.println("Initial matrix:");
        printMatrix(matrix);

        byte[][] transposedMatrix = transposeMatrix(matrix);

        System.out.println("Transported matrix:");
        printMatrix(transposedMatrix);

        int minSum = calculateMinRowSum(matrix);
        System.out.println("The sum of the lowest elements of every row: " + minSum);

        scanner.close();
    }

    public static byte[][] transposeMatrix(byte[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        byte[][] transposedMatrix = new byte[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static int calculateMinRowSum(byte[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            byte min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            sum += min;
        }

        return sum;
    }

    public static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}