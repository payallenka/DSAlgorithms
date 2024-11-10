package Searching;

public class BinarySearch {

    // This method implements Binary Search to find the element in a sorted array
    public static void searchingAlgorithm(int[] array, int elementToBeSearched) {

        // Initialize start and end pointers
        int start = 0;
        int end = array.length - 1;  // Corrected end index to be array.length - 1

        // Perform Binary Search as long as the search range is valid
        while (start <= end) {  // Use start <= end to avoid missing the last element

            // Calculate the middle index
            int mid = start + (end - start) / 2;  // Prevents overflow compared to (start + end) / 2

            // Check if the elementToBeSearched is at the mid position
            if (array[mid] == elementToBeSearched) {
                System.out.println("Element found at index " + mid);  // Print the index of the element
                return;  // Exit the method as we've found the element
            }

            // If the element is smaller than the middle element, search in the left half
            else if (elementToBeSearched < array[mid]) {
                end = mid - 1;  // Adjust end to mid - 1, excluding mid itself
            }
            // If the element is larger than the middle element, search in the right half
            else if (elementToBeSearched > array[mid]) {
                start = mid + 1;  // Adjust start to mid + 1, excluding mid itself
            }
        }

        // If the element is not found, print a message
        System.out.println("Element not found");
    }

    // Main method to test the Binary Search implementation
    public static void main(String[] args) {

        // Sample sorted array to search in
        int[] array = {1, 2, 3, 4, 5, 7, 8, 9, 10};

        // Print message and call the search method for element 2
        System.out.println("Finding the element 2");
        searchingAlgorithm(array, 2);  // Searching for element 2

        // Print message and call the search method for element 11
        System.out.println("Finding the element 11");
        searchingAlgorithm(array, 11);  // Searching for element 11
    }
}
