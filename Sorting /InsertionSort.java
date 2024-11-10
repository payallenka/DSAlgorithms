public class InsertionSort {

    public static void sortingAlgorithm(int[] array) {
        int sizeOfArray = array.length;
        
        // Start from the second element (index 1)
        for (int i = 1; i < sizeOfArray; i++) {
            int key = array[i];  // Element to be inserted
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;  // Place the key in the correct position
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 1, 2, 4, 5, 7, 6};

        System.out.println("The Array before the sorting has been performed:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        sortingAlgorithm(array);

        System.out.println("The Array after the sorting has been performed:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
