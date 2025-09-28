import java.util.Arrays;

public class CLI {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java CLI <algorithm> <args>");
            return;
        }

        String algorithm = args[0];

        switch (algorithm) {
            case "mergesort":
                int[] mergeSortArr = {38, 27, 43, 3, 9, 82, 10};
                MergeSort.mergeSort(mergeSortArr, new int[mergeSortArr.length], 0, mergeSortArr.length - 1);
                System.out.println("MergeSort: " + Arrays.toString(mergeSortArr));
                break;
            case "quicksort":
                int[] quickSortArr = {38, 27, 43, 3, 9, 82, 10};
                QuickSort.quickSort(quickSortArr, 0, quickSortArr.length - 1);
                System.out.println("QuickSort: " + Arrays.toString(quickSortArr));
                break;
            case "select":
                int[] selectArr = {38, 27, 43, 3, 9, 82, 10};
                int k = 3;
                int selectResult = DeterministicSelect.deterministicSelect(selectArr, 0, selectArr.length - 1, k);
                System.out.println("Deterministic Select: " + selectResult);
                break;
            case "closestpair":
                ClosestPair.Point[] points = {
                        new ClosestPair.Point(0, 0),
                        new ClosestPair.Point(1, 1),
                        new ClosestPair.Point(3, 3),
                        new ClosestPair.Point(6, 6)
                };
                double closestDist = ClosestPair.closestPair(points);
                System.out.println("Closest Pair Distance: " + closestDist);
                break;
            default:
                System.out.println("Unknown algorithm: " + algorithm);
        }
    }
}
