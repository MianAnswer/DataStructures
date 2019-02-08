import java.util.Arrays;

class Sort {

    public static void insertion(int[] arr) {
        System.out.println("---------------------------------");
        System.out.println("-----Inside Insertion method-----\n");
        int length = arr.length;

        for (int i = 1; i < length; ++i) {
            int k = i;
            // Show list as order changes
            System.out.println("Sorting... " + Arrays.toString(arr));
            for (int j = k - 1; j >= 0; --j) {
                // If value in current location is smaller than value in preceding location,
                // then swap values
                if (arr[k] <= arr[j]) {
                    // Swap
                    int temp = arr[k];
                    arr[k] = arr[j];
                    arr[j] = temp;
                    --k;
                }
                // Otherwise, exit inner-loop. Values are already in order
                else {
                    break;
                }
            }
        }

        // Final list
        System.out.println("Sorted:    " + Arrays.toString(arr));
        System.out.println("\n-----End of Insertion method-----");
        System.out.println("---------------------------------");
    }

    public static void merge(int[] arr) {
        System.out.println("---------------------------------");
        System.out.println("-----Inside Merge method-----\n");

        mergeSort(arr, 0, arr.length - 1);

        // Final list
        System.out.println("Sorted:    " + Arrays.toString(arr));
        System.out.println("\n-----End of Merge method-----");
        System.out.println("---------------------------------");
    }

    /**
     * Merge
     */
    private static void mergeSort(int[] arr, int beginning, int end) {
        int middle = (beginning + (end - beginning) / 2);

        if (beginning == end) {
            return;
        }

        // Left
        mergeSort(arr, beginning, middle);
        // Right
        mergeSort(arr, middle + 1, end);

        int i = beginning;
        int j = middle + 1;

        while ((i != middle + 1) && (j != end + 1)) {
            if (arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                System.out.println("Sorting... " + "[" + beginning + ", " + end + "]"+ Arrays.toString(arr));
                ++i;
            } else {
                ++j;
            }
        }
    }
}