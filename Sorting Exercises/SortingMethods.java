import java.util.Scanner;

public class SortingMethods {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] list = new int[10];

        enterFromKeyboard(list);

        while (true) {
            System.out.println("\n--------HAYLEY'S SORTING EXERCISES MAIN MENU--------");
            System.out.println("Plase select a sorting algorithm:\n" +
                               "    1. Bubble sort\n" +
                               "    2. Improved Bubble Sort\n" +
                               "    3. Selection Sort\n" +
                               "    4. Insertion Sort\n" +
                               "    5. Quick Sort\n" +
                               "    6. Merge Sort\n" +
                               "    7. Heap Sort\n" +
                               "    8. Exit the program");
            System.out.print("Enter # of desired action: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    bubbleSort(list);
                    display(list, true);
                    break;
                case "2":
                    improvedBubbleSort(list);
                    display(list, true);
                    break;
                case "3":
                    selectionSort(list);
                    display(list, true);
                    break;
                case "4":
                    insertionSort(list);
                    display(list, true);
                    break;
                case "5":
                    quickSort(list, 0, list.length - 1);
                    display(list, true);
                    break;
                case "8":
                    System.out.println("Thank you for using the program! :)");
                    return;
                default:
                    System.out.println("Please enter a valid # from the menu.");
            }
        }
    }

    public static void enterFromKeyboard(int[] list) {
        for (int i = 0; i < list.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Please enter an integer " + (i + 1) + "/" + list.length + ": ");
                try {
                    list[i] = Integer.parseInt(sc.nextLine());
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Try again. Please enter an integer value.");
                }
            }
        }
    }

    public static void display(int[] list, boolean sorted) {
        System.out.print(sorted ? "The integers in ascending order are: " : "The integers in order entered are: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + (i < list.length - 1 ? ", " : "."));
        }
        System.out.println();
    }

    // Bubble Sort
    public static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    // Improved Bubble Sort
    public static void improvedBubbleSort(int[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Selection Sort
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j=1+i; j < list.length; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            swap(list, minIndex, i);
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] list) {
        for (int i=1; i<list.length; i++) {
            int currValue = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > currValue) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = currValue;
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Helper method for Quick Sort
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // Helper method for swapping elements in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Merge Sort
    public static void mergeSort(int[] list) {
        if (list.length < 2) {
            return; 
        }
        
        int mid = list.length / 2;
        int[] left = new int[mid];
        int[] right = new int[list.length - mid];
        
        for (int i = 0; i < mid; i++) {
            left[i] = list[i];
        }
        for (int i = mid; i < list.length; i++) {
            right[i - mid] = list[i];
        }
        
        mergeSort(left);
        mergeSort(right);
        
        merge(list, left, right);
    }
    
    // Helper method to merge two arrays
    private static void merge(int[] list, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
    
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                list[k++] = left[i++];
            } else {
                list[k++] = right[j++];
            }
        }
    
        while (i < left.length) {
            list[k++] = left[i++];
        }
    
        while (j < right.length) {
            list[k++] = right[j++];
        }
    }
    
    // Heap Sort
    public static void heapSort(int[] list) {
        int n = list.length;
    
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }
    
        for (int i = n - 1; i >= 0; i--) {
            swap(list, 0, i);
            heapify(list, i, 0);
        }
    }
    
    // Helper method to maintain the heap property
    private static void heapify(int[] list, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1;
        int right = 2 * i + 2; 
    
        if (left < n && list[left] > list[largest]) {
            largest = left;
        }
    
        if (right < n && list[right] > list[largest]) {
            largest = right;
        }
    
        if (largest != i) {
            swap(list, i, largest);
            heapify(list, n, largest);
        }
    }
    
}
