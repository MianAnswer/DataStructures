import java.util.Arrays;

class SortAlgorithm {

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

        arr = mergeSort(arr, 0, arr.length - 1);

        // Final list
        System.out.println("Sorted:    " + Arrays.toString(arr));
        System.out.println("\n-----End of Merge method-----");
        System.out.println("---------------------------------");
    }

    /**
     * Merge
     */
    private static int[] mergeSort(int[] arr, int beginning, int end) {
        int middle = (beginning + (end - beginning) / 2);

        if (beginning == end) {
            return new int[]{arr[beginning]};
        }

        // Left
        int[] arrLeft = mergeSort(arr, beginning, middle);
        int leftLength = arrLeft.length;
        // Right
        int[] arrRight = mergeSort(arr, middle + 1, end);
        int rightLength = arrRight.length;
        // Merged array
        int[] mergedArray = new int[leftLength + rightLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while ((i < leftLength) && (j < rightLength)) {
            if (arrLeft[i] > arrRight[j]) {
                mergedArray[k] = arrRight[j];
                ++j;
            } else {
                mergedArray[k] = arrLeft[i];
                ++i;
            }
            ++k;
        }

        if (k < mergedArray.length) {
            int[] leftOver = {};
            int leftOverIndex = 0;
            if (i != leftLength) {
                leftOver = arrLeft;
                leftOverIndex = i;
            } else if (j != rightLength) {
                leftOver = arrRight;
                leftOverIndex = j;
            }
            while (k < mergedArray.length && leftOverIndex < leftOver.length) {
                mergedArray[k++] = leftOver[leftOverIndex++];
            }
        }
        System.out.println("Sorting... " + "[" + beginning + ", " + end + "]"+ Arrays.toString(mergedArray));
        return mergedArray;
    }
}