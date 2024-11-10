public class MergeSort {

    // Main function to perform merge sort on the input array
    public static void sortingAlgorithm(int[] array) {
        
        // Base case: if the array has fewer than 2 elements, it's already sorted
        if (array.length < 2) {
            return;
        }

        // Find the middle index of the array
        int mid = array.length / 2;

        // Create two subarrays: one for the left part and one for the right part
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Copy data into the left and right subarrays
        System.arraycopy(array, 0, left, 0, mid);              // Copy the first half into left
        System.arraycopy(array, mid, right, 0, array.length - mid); // Copy the second half into right

        // Recursively sort the left and right subarrays
        sortingAlgorithm(left);
        sortingAlgorithm(right);

        // Merge the sorted subarrays back into the original array
        merge(array, left, right);
    }

    // Helper function to merge two sorted subarrays into the original array
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge elements from left and right subarrays into the original array
        while (i < left.length && j < right.length) {
            // Compare the current elements from both subarrays
            if (left[i] <= right[j]) {
                // If left element is smaller or equal, put it in the original array
                array[k++] = left[i++];
            } else {
                // If right element is smaller, put it in the original array
                array[k++] = right[j++];
            }
        }

        // If there are remaining elements in the left subarray, copy them
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // If there are remaining elements in the right subarray, copy them
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Main method to test the Merge Sort
    public static void main(String[] args) {
        // Sample array to be sorted
        int[] array = {3, 4, 1, 2, 4, 5, 7, 6};

        // Print the array before sorting
        System.out.println("The Array before the sorting has been performed:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Call the sortingAlgorithm method to sort the array
        sortingAlgorithm(array);

        // Print the array after sorting
        System.out.println("The Array after the sorting has been performed:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
