public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 0, 1, 4};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currValue = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > currValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = currValue;
        }
    }
}