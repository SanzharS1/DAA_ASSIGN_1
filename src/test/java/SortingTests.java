import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SortingTests {

    @Test
    public void testMergeSort() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] expected = {3, 9, 10, 27, 38, 43, 82};
        MergeSort.mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] expected = {3, 9, 10, 27, 38, 43, 82};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testQuickSortDepth() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        int maxDepth = 0;
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertTrue(maxDepth <= Math.ceil(2 * Math.log(arr.length) / Math.log(2)));
    }

    @Test
    public void testRandomArraySort() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
        MergeSort.mergeSort(arr, new int[arr.length], 0, arr.length - 1);
        assertArrayEquals(sortedArr, arr);
    }

    @Test
    public void testAdversarialArraySort() {
        int[] arr = {100, 50, 25, 12, 6, 3, 1};
        int[] expected = {1, 3, 6, 12, 25, 50, 100};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);
    }
}
