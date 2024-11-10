package Searching;

public class LinearSearch {

    // This method performs Linear Search to find the given element in the array
    public static void searchingAlgorithm(int[] array, int elementToBeSearched){

        // Get the length of the array
        int n = array.length;

        // Loop through each element in the array
        for(int i = 0; i < n; i++){
            // Check if the current element is equal to the element we're searching for
            if(array[i] == elementToBeSearched){
                // If found, print the index (i+1 for 1-based index)
                System.out.println("Element found at location " + (i + 1));
                return;  // Exit the method as we found the element
            }
        }

        // If the loop completes and the element is not found, print a message
        System.out.println("Element not found");
    }

    // Main method to test the Linear Search implementation
    public static void main(String[] args){

        // Sample array to search in
        int[] array = {1, 2, 3, 4, 5, 7, 8, 9, 10};

        // Print message and call the search method for element 2
        System.out.println("Finding the element 2");
        searchingAlgorithm(array, 2);  // Searching for element 2

        // Print message and call the search method for element 11
        System.out.println("Finding the element 11");
        searchingAlgorithm(array, 11);  // Searching for element 11
    }
}
