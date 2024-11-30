package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixLabTest {

    @Test
    public void testTransposeMatrix() {

        byte[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        byte[][] expectedTransposedMatrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        byte[][] transposedMatrix = MatrixLab.transposeMatrix(matrix);
        assertArrayEquals(expectedTransposedMatrix, transposedMatrix);
    }

    @Test
    public void testCalculateMinRowSum() {
        byte[][] matrix1 = {
                {5, 8, 3},
                {1, 2, 7},
                {9, 5, 0}
        };
        int expectedSum1 = 4;  // 3 + 1 + 0
        int actualSum1 = MatrixLab.calculateMinRowSum(matrix1);
        assertEquals(expectedSum1, actualSum1);

        byte[][] matrix2 = {
                {-5, -8, -3},
                {-1, -2, -7},
                {-9, -5, 0}
        };
        int expectedSum2 = -24; // -8 + -7 + -9
        int actualSum2 = MatrixLab.calculateMinRowSum(matrix2);
        assertEquals(expectedSum2, actualSum2);

        byte[][] matrix3 = {
                {4, 4, 4},
                {4, 4, 4},
                {4, 4, 4}
        };
        int expectedSum3 = 12;  // 4 + 4 + 4
        int actualSum3 = MatrixLab.calculateMinRowSum(matrix3);
        assertEquals(expectedSum3, actualSum3);
    }

    @Test
    public void testPrintMatrix() {

        byte[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        MatrixLab.printMatrix(matrix);
    }
}
