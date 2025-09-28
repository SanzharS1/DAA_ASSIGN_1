import java.util.Random;

public class Util {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shuffle(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    public static boolean isValidIndex(int[] arr, int index) {
        return index >= 0 && index < arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Util.swap(arr, 0, 4);
        System.out.println(java.util.Arrays.toString(arr));

        Util.shuffle(arr);
        System.out.println(java.util.Arrays.toString(arr));

        System.out.println(Util.isValidIndex(arr, 3));
        System.out.println(Util.isValidIndex(arr, 5));
    }
}

