public class QuickSort {
    public static void main(String args[]) {
        int[] arr = {3, 2, 0, 8, 1, 7, 9, 5, 4};
        int length = arr.length;

        quickSort(arr, 0, length - 1);

        System.out.println("The sorted array:");
        printArr(arr);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  
        int i = (low - 1); 

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;   
                // Swap arr[i] and arr[j]
                swap(arr, i, j); 
            }
        }
        // Swap pivot with the element at i + 1
        swap(arr, i + 1, high); 
        return (i + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}