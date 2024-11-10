

public class SelectionSort {

    public static void sortingAlgorithm(int[] array) {
        int sizeOfArray = array.length;

        for (int i = 0; i < sizeOfArray - 1; i++) {
            int minIndex = i;

            // Find the index of the minimum element in the remaining unsorted section
            for (int j = i + 1; j < sizeOfArray; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;  // Update minIndex if a smaller element is found
                }
            }

            // Swap the found minimum element with the first element of the unsorted section
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
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
