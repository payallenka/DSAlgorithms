

class BubbleSort {

    public static void sortingAlgorithm(int[] array) {
        int sizeOfArray = array.length;

        // Outer loop for each pass
        for (int i = 0; i < sizeOfArray - 1; i++) {
            // Inner loop for comparison and swapping
            for (int j = 0; j < sizeOfArray - 1 - i; j++) {
                // Compare adjacent elements
                if (array[j] > array[j + 1]) {
                    // Swap if they are in the wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
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
