import java.util.Arrays;

public class Array2DOperations {

    // 1. Standard 2D Grid Printing
    public static void print2DArray(int[][] arr) {
        System.out.println("--- Standard 2D Array Printing ---");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 2. Snake Order Row-Wise Printing
    public static void printSnakeRowWise(int[][] arr) {
        System.out.println("--- Snake Printing (Row-Wise) ---");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = arr[0].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // 3. Snake Order Column-Wise Printing
    public static void printSnakeColWise(int[][] arr) {
        System.out.println("--- Snake Printing (Column-Wise) ---");
        for (int j = 0; j < arr[0].length; j++) {
            if (j % 2 == 0) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // 4. Transpose of a Square Matrix (In-Place)
    public static void transposeMatrix(int[][] arr) {
        System.out.println("--- Transposing Matrix In-Place ---");
        int rows = arr.length;
        int cols = arr[0].length;
        if (rows != cols) {
            System.out.println("In-place transpose only supported for square matrices.");
            return;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    // 5. Column-Wise Standard Printing
    public static void printColWise(int[][] arr) {
        System.out.println("--- Column-Wise Printing ---");
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 6. Find minimum value among the maximum element of each row
    public static void findMinOfRowMaxs(int[][] arr) {
        System.out.println("--- Find Minimum of Row Maximums ---");
        int[] maxs = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int maxInRow = Integer.MIN_VALUE;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > maxInRow) {
                    maxInRow = arr[i][j];
                }
            }
            maxs[i] = maxInRow;
        }

        int minOfMaxs = Integer.MAX_VALUE;
        for (int val : maxs) {
            if (val < minOfMaxs) {
                minOfMaxs = val;
            }
        }
        System.out.println("Row Maxima: " + Arrays.toString(maxs));
        System.out.println("Minimum of Row Maxima: " + minOfMaxs);
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = {
            {2, 8, 3, 4},
            {7, 2, 1, 6},
            {5, 5, 4, 1},
            {3, 1, 8, 2}
        };

        print2DArray(arr);
        printSnakeRowWise(arr);
        printSnakeColWise(arr);
        printColWise(arr);
        findMinOfRowMaxs(arr);

        transposeMatrix(arr);
        System.out.println("After Transposition:");
        print2DArray(arr);
    }
}
