package array;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeros {

    static void markRow(ArrayList<ArrayList<Integer>> matrix,
            int currentRow, int rowLength) {
        for (int i = 0; i < rowLength; i++) {
            if (matrix.get(currentRow).get(i) != 0) {
                matrix.get(currentRow).set(i, -1);

            }
        }

    }

    static void markColumn(ArrayList<ArrayList<Integer>> matrix,
            int currentColumn, int columnLength) {
        for (int i = 0; i < columnLength; i++) {
            if (matrix.get(i).get(currentColumn) != 0) {
                matrix.get(i).set(currentColumn, -1);

            }
        }
    }

    // brute force
    public static ArrayList<ArrayList<Integer>> setMatrixZeroBruteForce(ArrayList<ArrayList<Integer>> matrix,
            int rowLength, int columnLength) {
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markColumn(matrix, j, columnLength);
                    markRow(matrix, i, rowLength);
                }
            }
        }

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }

        return matrix;
    }

    // better approach
    public static void setMatrixZeroBetterApproach(int[][] arr) {
        ArrayList<Integer> rowArray = new ArrayList<>();
        ArrayList<Integer> colArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    rowArray.set(i, 1);
                    colArray.set(j, 1);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (rowArray.get(i) == 0 || colArray.get(j) == 0) {
                    arr[i][j] = 0;
                }
            }
        }

    }

    // optimal approach
    public static void setZerosMostOptimalApproach(int matrix[][]) {

        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Inside the main method");
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = setMatrixZeroBruteForce(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}