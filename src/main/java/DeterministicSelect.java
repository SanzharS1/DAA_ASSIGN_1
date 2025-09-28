import java.util.*;

public class DeterministicSelect {

    public static int medianOfMedians(int[] arr, int left, int right) {
        if (right - left < 5) {
            Arrays.sort(arr, left, right + 1);
            return arr[(left + right) / 2];
        }

        for (int i = left; i <= right; i += 5) {
            int subRight = Math.min(i + 4, right);
            Arrays.sort(arr, i, subRight + 1);
            int medianIndex = (i + subRight) / 2;
            swap(arr, medianIndex, left + (i - left) / 5);
        }

        return medianOfMedians(arr, left, left + (right - left) / 5);
    }

    private static void swap(int[] arr, int medianIndex, int i) {
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        int pivotIndex = -1;
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivot) {
                pivotIndex = i;
                break;
            }
        }
        swap(arr, pivotIndex, right);
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    public static int deterministicSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        int pivot = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivot);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return deterministicSelect(arr, left, pivotIndex - 1, k);
        } else {
            return deterministicSelect(arr, pivotIndex + 1, right, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int k = 3;
        int result = deterministicSelect(arr, 0, arr.length - 1, k);
        System.out.println(result);
    }
}
