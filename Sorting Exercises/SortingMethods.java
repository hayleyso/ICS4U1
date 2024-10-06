import java.util.Scanner;

public class SortingMethods {
    static Scanner sc = new Scanner(System.in);
    static final int MAX = 10;

    public static void main(String[] args) {
        int[] list = new int[MAX];

        enterFromKeyboard(list);

        while (true) {
            System.out.println("\n--------HAYLEY'S SORTING EXERCISES MAIN MENU--------");
            System.out.println("    Would you like to sort the array using:");
            System.out.println("          1. Bubble sort");
            System.out.println("          2. Improved Bubble Sort");
            System.out.println("          3. Selection Sort");
            System.out.println("          4. Insertion Sort");
            System.out.println("          5. Quick Sort");
            System.out.println("          6. Merge Sort");
            System.out.println("          7. Heap Sort");
            System.out.println("          8. Exit the program");
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
                    quickSort(list, 0, MAX - 1);
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
        for (int i = 0; i < MAX; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Please enter an integer " + (i + 1) + "/" + MAX + ": ");
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
        for (int i = 0; i < MAX; i++) {
            System.out.print(list[i] + (i < MAX - 1 ? ", " : "."));
        }
        System.out.println();
    }

    // Bubble Sort
    public static void bubbleSort(int[] list) {
        for (int i = 0; i < MAX - 1; i++) {
            for (int j = 0; j < MAX - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    // Improved Bubble Sort
    public static void improvedBubbleSort(int[] list) {
        boolean swapped;
        for (int i = 0; i < MAX - 1; i++) {
            swapped = false;
            for (int j = 0; j < MAX - 1 - i; j++) {
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
        for (int i = 0; i < MAX - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < MAX; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            swap(list, minIndex, i);
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] list) {
        for (int i = 1; i < MAX; i++) {
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
    // Places pivot at correct position, smaller elements left, larger right
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
}
