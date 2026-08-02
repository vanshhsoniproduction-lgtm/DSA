import java.util.Arrays;

public class Array1DBasics {

    // Reverse an array in-place using two-pointer approach
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Find Max and Min in an array
    public static void findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        System.out.println("Min: " + min + ", Max: " + max);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 40, 30};
        System.out.println("Original Array: " + Arrays.toString(arr));
        findMinMax(arr);
        reverseArray(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
    }
}
