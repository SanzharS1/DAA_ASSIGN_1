import java.util.Arrays;

public class MergeSort {

    public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > right) {
                arr[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }
    }

    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (right - left <= 10) { // Мелкие массивы сортируем вставками
            insertionSort(arr, left, right);
        } else {
            if (left < right) {
                int mid = (left + right) / 2;
                mergeSort(arr, temp, left, mid);
                mergeSort(arr, temp, mid + 1, right);
                merge(arr, temp, left, mid, right);
            }
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
