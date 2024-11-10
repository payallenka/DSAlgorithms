public class QuickSort {

    // Main function to perform the Quick Sort algorithm
    public static void sortingAlgorithm(int[] array, int low, int high) {
        
        // Base case: If low < high, the array has more than one element, so sort it
        if (low < high) {

            // Get the index of the pivot after partitioning the array
            int pivotIndex = partition(array, low, high);

            // Recursively apply quick sort to the left subarray (elements less than pivot)
            sortingAlgorithm(array, low, pivotIndex - 1);

            // Recursively apply quick sort to the right subarray (elements greater than pivot)
            sortingAlgorithm(array, pivotIndex + 1, high);
        }
    }

    // Partition the array around the pivot element
    public static int partition(int[] array, int low, int high) {
        // Pivot is chosen as the last element in the array
        int pivot = array[high];

        // Initialize the pointer for the smaller element (starting just before the low index)
        int i = (low - 1);

        // Loop through the array and rearrange elements based on the pivot
        for (int j = low; j < high; j++) {
            // If the current element is less than or equal to the pivot, swap it to the left side
            if (array[j] <= pivot) {
                i++;  // Increment the pointer for smaller elements
                swap(array, i, j);  // Swap array[i] and array[j]
            }
        }

        // Finally, place the pivot element in the correct position by swapping it with array[i+1]
        swap(array, i + 1, high);

        // Return the index of the pivot element in its final sorted position
        return i + 1;
    }

    // Helper function to swap two elements in the array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];  // Store element at index i in a temporary variable
        array[i] = array[j];  // Set element at index i to the value at index j
        array[j] = temp;      // Set element at index j to the value stored in temp
    }

    // Main method to test the QuickSort algorithm
    public static void main(String[] args) {
        // Sample array to be sorted
        int[] array = {3, 4, 1, 2, 4, 5, 7, 6};

        // Print the array before sorting
        System.out.println("The Array before the sorting has been performed:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Call the sortingAlgorithm method to sort the array (passing 0 as low and array.length-1 as high)
        sortingAlgorithm(array, 0, array.length - 1);

        // Print the array after sorting
        System.out.println("The Array after the sorting has been performed:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
